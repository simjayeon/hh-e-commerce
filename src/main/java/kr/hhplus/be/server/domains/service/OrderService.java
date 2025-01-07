package kr.hhplus.be.server.domains.service;

import kr.hhplus.be.server.dto.request.OrderRequest;
import kr.hhplus.be.server.dto.response.CouponResponse;
import kr.hhplus.be.server.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    public ResponseEntity<OrderResponse> getOrders(Long userId, Long orderId) {
        return null;
    }

    public ResponseEntity<Boolean> createOrder(OrderRequest req) {
        return null;
    }

}
