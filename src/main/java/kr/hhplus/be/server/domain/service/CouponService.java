package kr.hhplus.be.server.domain.service;

import jakarta.transaction.Transactional;
import kr.hhplus.be.server.domain.entity.UserCoupon;
import kr.hhplus.be.server.domain.repository.IUserCouponRepository;
import kr.hhplus.be.server.interfaces.dto.enumeration.CouponStatus;
import kr.hhplus.be.server.interfaces.dto.response.CouponResponse;
import kr.hhplus.be.server.support.exception.NotFoundException;
import kr.hhplus.be.server.support.exception.NullPointerException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final IUserCouponRepository userCouponRepository;

    public ResponseEntity<List<CouponResponse>> getUserCoupons(Long userId) {
        List<UserCoupon> userCoupons = userCouponRepository.findAllByUserId(userId);

        List<CouponResponse> couponResponses;
        try {
            couponResponses = userCoupons.stream()
                    .map(userCoupon -> CouponResponse.builder()
                            .couponId(userCoupon.getCouponId())
                            .couponName(userCoupon.getCoupon().getName())
                            .couponCode(userCoupon.getCoupon().getCode())
                            .discountAmount(userCoupon.getCoupon().getDiscountAmount())
                            .startAt(userCoupon.getCoupon().getStartAt().toLocalDateTime())
                            .endAt(userCoupon.getCoupon().getEndAt().toLocalDateTime())
                            .status(CouponStatus.valueOf(userCoupon.getStatus()))
                            .build())
                    .toList();
        } catch (NotFoundException e) {
            throw new NotFoundException("유저에게 발급된 쿠폰이 없습니다.", e);
        }

        return ResponseEntity.ok(couponResponses);
    }

    @Transactional
    public ResponseEntity<Boolean> issueCoupon(Long userId) {


        return null;
    }
}
