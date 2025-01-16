package kr.hhplus.be.server.interfaces.dto.response;


import kr.hhplus.be.server.interfaces.dto.enumeration.CouponStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public record CouponResponse(
        Long couponId,
        String couponName,
        String couponCode,
        Double discountAmount,
        CouponStatus status,
        LocalDateTime startAt,
        LocalDateTime endAt
) {
}
