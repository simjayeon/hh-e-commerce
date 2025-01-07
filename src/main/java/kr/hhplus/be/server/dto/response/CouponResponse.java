package kr.hhplus.be.server.dto.response;


import kr.hhplus.be.server.dto.enumeration.CouponStatus;

import java.time.LocalDateTime;

public record CouponResponse(
        Long couponId,
        String couponName,
        String couponCode,
        Long discountAmount,
        CouponStatus status,
        LocalDateTime startAt,
        LocalDateTime endAt
) {
}
