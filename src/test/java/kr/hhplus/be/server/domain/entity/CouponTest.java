package kr.hhplus.be.server.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.sql.Timestamp;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = TestcontainersConfiguration.class)
public class CouponTest {

    @Test
    @DisplayName("쿠폰 생성 테스트")
    void 쿠폰_생성_요청시_생성되면_200_반환() {

        Coupon coupon = new Coupon();
        coupon.setCode("SIGNUP-10-PERCENT");
        coupon.setName("신규가입 10% 할인 쿠폰");
        coupon.setDiscountAmount(0.1);
        coupon.setIssuedQuantity(10);
        coupon.setStartAt(Timestamp.valueOf("2025-01-20"));
        coupon.setEndAt(Timestamp.valueOf("2025-01-24"));
        coupon.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        coupon.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        assertThat(coupon.getId()).isNull();
        assertThat(coupon.getCode()).isNotNull();
        assertThat(coupon.getName()).isNotNull();
        assertThat(coupon.getDiscountAmount()).isNotNull();
        assertThat(coupon.getIssuedQuantity()).isNotNull();
        assertThat(coupon.getStartAt()).isNotNull();
        assertThat(coupon.getEndAt()).isNotNull();
        assertThat(coupon.getCreatedAt()).isNotNull();
        assertThat(coupon.getUpdatedAt()).isNotNull();

    }

}
