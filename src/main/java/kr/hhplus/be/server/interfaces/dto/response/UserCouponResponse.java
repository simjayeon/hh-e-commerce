package kr.hhplus.be.server.interfaces.dto.response;

import kr.hhplus.be.server.domain.entity.Coupon;
import kr.hhplus.be.server.domain.entity.OrderItem;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public record UserCouponResponse(
        Long userId,
        List<CouponResponse> coupons
) {

}
