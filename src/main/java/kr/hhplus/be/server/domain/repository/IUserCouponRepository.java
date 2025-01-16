package kr.hhplus.be.server.domain.repository;


import kr.hhplus.be.server.domain.entity.UserCoupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserCouponRepository {
    @Query("""
            SELECT up FROM UserCoupon up
            JOIN FETCH up.coupon
            WHERE up.userId = :userId
            """)
    List<UserCoupon> findAllByUserId(@Param("userId") Long userId);
}
