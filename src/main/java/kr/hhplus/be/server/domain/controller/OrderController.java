package kr.hhplus.be.server.domain.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.domain.service.OrderService;
import kr.hhplus.be.server.dto.request.OrderRequest;
import kr.hhplus.be.server.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{userId}/{orderId}")
    @Operation(summary = "getOrders", description = "주문 조회")
    public ResponseEntity<OrderResponse> getOrders(@PathVariable Long userId,
                                                   @PathVariable Long orderId) {
        return orderService.getOrders(userId, orderId);
    }

    @PostMapping("")
    @Operation(summary = "createOrder", description = "주문 요청")
    public ResponseEntity<Boolean> createOrder(@RequestBody OrderRequest req) {
        return orderService.createOrder(req);
    }

}