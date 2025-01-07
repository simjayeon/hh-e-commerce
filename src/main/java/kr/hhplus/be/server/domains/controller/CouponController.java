package kr.hhplus.be.server.domains.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.domains.service.CouponService;
import kr.hhplus.be.server.dto.response.CouponResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/{userId}")
    @Operation(summary = "getUserCoupons", description = "사용자 보유 쿠폰 목록 조회")
    public ResponseEntity<List<CouponResponse>> getUserCoupons(@PathVariable Long userId) {
        return couponService.getUserCoupons(userId);
    }

    @PostMapping("/issue/{userId}")
    public ResponseEntity<Boolean> issueCoupon(@PathVariable Long userId) {
        return couponService.issueCoupon(userId);
    }

}
