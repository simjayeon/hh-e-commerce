package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.domain.repository.OrderItemRepositoryImpl;
import kr.hhplus.be.server.domain.repository.OrderRepositoryImpl;
import kr.hhplus.be.server.dto.request.OrderRequest;
import kr.hhplus.be.server.dto.request.ProductRequest;
import kr.hhplus.be.server.dto.response.OrderResponse;
import kr.hhplus.be.server.dto.response.ProductResponse;
import kr.hhplus.be.server.entity.Order;
import kr.hhplus.be.server.entity.OrderItem;
import kr.hhplus.be.server.support.exception.ErrorCode;
import kr.hhplus.be.server.support.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepositoryImpl orderRepository;
    private final OrderItemRepositoryImpl orderItemRepository;

    public ResponseEntity<OrderResponse> getOrders(Long userId, Long orderId) {
        // 주문 상품 조회
        List<OrderItem> orderItems = orderItemRepository.findAllByUserIdAndOrderId(userId, orderId);

        // 주문 상품이 없을 경우 예외 처리
        if (orderItems.isEmpty()) {
            throw new NotFoundException(ErrorCode.NOT_FOUND.getMessage());
        }

        // 주문 상품을 주문 ID로 그룹핑
        Map<Long, List<OrderItem>> orderItemMap = orderItems.stream()
                .collect(groupingBy(h -> h.getOrder().getId()));

        // 주문 상품의 상품 조회
        List<ProductResponse> productResponses = orderItemMap.get(orderId).stream()
                .map(h -> ProductResponse.of(h.getProduct()))
                .toList();

        // Entity > DTO 변환
        OrderResponse orderResponses = OrderResponse.of(orderItems.get(0), productResponses);

        return ResponseEntity.ok(orderResponses);
    }

    public ResponseEntity<Boolean> createOrder(OrderRequest req) {
        // 주문 생성
        Order order = Order.builder()
                .userId(req.userId())
                .orderedAt(new Timestamp(System.currentTimeMillis()))
                .quantity(req.products().size())
                .totalAmount(req.products().stream().mapToInt(ProductRequest::productPrice).sum())
                .build();

        orderRepository.save(order);

        // 주문 상품
        for (ProductRequest product : req.products()) {
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .productId(product.productId())
                    .quantity(product.productQuantity())
                    .build();

            orderItemRepository.save(orderItem);
        }

        return ResponseEntity.ok(true);
    }

}
