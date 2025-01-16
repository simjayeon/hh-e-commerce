package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.domain.entity.Product;
import kr.hhplus.be.server.domain.repository.IOrderItemRepository;
import kr.hhplus.be.server.domain.repository.IOrderRepository;
import kr.hhplus.be.server.domain.repository.IProductRepository;
import kr.hhplus.be.server.interfaces.dto.enumeration.OrderStatus;
import kr.hhplus.be.server.interfaces.dto.request.OrderRequest;
import kr.hhplus.be.server.interfaces.dto.request.ProductRequest;
import kr.hhplus.be.server.interfaces.dto.response.OrderResponse;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import kr.hhplus.be.server.domain.entity.Order;
import kr.hhplus.be.server.domain.entity.OrderItem;
import kr.hhplus.be.server.support.exception.NotFoundException;
import kr.hhplus.be.server.support.exception.NullPointerException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final IOrderRepository orderRepository;
    private final IOrderItemRepository orderItemRepository;
    private final IProductRepository productRepository;

    @Transactional
    public ResponseEntity<OrderResponse> getOrders(Long userId, Long orderId) {
        // 주문 상품 조회
        List<OrderItem> orderItems = orderItemRepository.findAllByOrderId(orderId);

        OrderResponse orderResponses;
        try {
            // 주문 상품이 없으면 예외 처리
            if (orderItems.isEmpty()) {
                throw new NotFoundException("주문 상품이 존재하지 않습니다.");
            }

            // 주문 상품을 주문 ID로 그룹핑
            Map<Long, List<OrderItem>> orderItemMap = orderItems.stream()
                    .collect(groupingBy(h -> h.getOrder().getId()));

            // 주문 상품의 상품 조회
            List<ProductResponse> productResponses = orderItemMap.get(orderId).stream()
                    .map(h -> ProductResponse.of(h.getProduct()))
                    .toList();

            // Entity > DTO 변환
            orderResponses = OrderResponse.of(orderItems.get(0), productResponses);
        } catch (Exception e) {
            // 주문 상품이 없을 경우 예외 처리
            throw new RuntimeException("주문 상품이 존재하지 않습니다.", e);
        }

        return ResponseEntity.ok(orderResponses);
    }

    @Transactional
    public ResponseEntity<Boolean> createOrder(OrderRequest req) {
        // 상품 조회
        List<Product> products = productRepository.findAllByIdIn(req.products().stream().map(ProductRequest::productId).toList());
        int totalPrice = products.stream()
                .filter(h -> req.products().stream().map(ProductRequest::productId).toList().contains(h.getId()))
                .mapToInt(h -> h.getPrice() * req.products().stream()
                        .filter(k -> k.productId().equals(h.getId()))
                        .mapToInt(ProductRequest::productQuantity).sum())
                .sum();

        // 주문 생성
        Order order = new Order();
        order.setUserId(req.userId());
        order.setOrderedAt(new Timestamp(System.currentTimeMillis()));
        order.setQuantity(req.products().stream().mapToInt(ProductRequest::productQuantity).sum());
        order.setTotalAmount(totalPrice);
        order.setStatus(OrderStatus.WAITING.name());
        orderRepository.save(order);

        // 주문 상품
        for (ProductRequest product : req.products()) {
            Optional<Product> productOpt = products.stream()
                    .filter(h -> h.getId().equals(product.productId()))
                    .findFirst();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(product.productId());
            orderItem.setQuantity(product.productQuantity());
            orderItem.setTotalPrice(productOpt.map(h -> h.getPrice() * product.productQuantity()).orElse(0));
            orderItemRepository.save(orderItem);
        }
        return ResponseEntity.ok(true);
    }

}
