package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.domain.entity.*;
import kr.hhplus.be.server.domain.repository.ICouponRepository;
import kr.hhplus.be.server.domain.repository.IOrderRepository;
import kr.hhplus.be.server.domain.repository.IUserRepository;
import kr.hhplus.be.server.interfaces.dto.enumeration.OrderStatus;
import kr.hhplus.be.server.interfaces.dto.response.OrderResponse;
import kr.hhplus.be.server.support.exception.InterruptedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = TestcontainersConfiguration.class)
public class CouponServiceTest {

    @Mock
    private ICouponRepository couponRepository;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private CouponService couponService;

    User user;

    public void setUp() {
        user = new User(1L, "Nature", "nature@email.com", "qwer1234");
    }

    @Test
    @DisplayName("쿠폰 발급 테스트")
    void 유저가_쿠폰_발급시_쿠폰정보_반환() {
        //given

    }

    @Test
    @DisplayName("선착순 쿠폰 발급 테스트")
    void 쿠폰을_20명이_동시_발급_요청시_15명_발급_성공_5명_실패() throws InterruptedException, java.lang.InterruptedException {
        Coupon coupon = new Coupon();
        coupon.setCode("SIGNUP-20-PERCENT");
        coupon.setName("신규가입 20% 할인 쿠폰");
        coupon.setDiscountAmount(0.1);
        coupon.setIssuedQuantity(10);
        coupon.setStartAt(Timestamp.valueOf("2025-01-20"));
        coupon.setEndAt(Timestamp.valueOf("2025-01-24"));
        coupon.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        coupon.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        List<User> users = new ArrayList<>();
        int maxUserCnt = 20;
        for (int i = 0; i < maxUserCnt; i++) {
            User user = User.builder()
                    .name("user" + i)
                    .email("user" + i + "@email.com")
                    .password("qwer1234")
                    .build();
            userRepository.save(user);
            users.add(userRepository.findById(user.getId()));
        }

        CountDownLatch latch = new CountDownLatch(20);
        for (User user : users) {
            try {
                couponService.issueCoupon(user.getId());
            } catch (Exception e) {
                throw new InterruptedException("쿠폰 발급 실패", e);
            } finally {
                latch.countDown();
            }
        }
        latch.await();

        verify(couponRepository, times(15)).save(any(Coupon.class));
    }

}
