package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.UserCoupon;
import kr.hhplus.be.server.domain.repository.IUserCouponRepository;
import kr.hhplus.be.server.infra.jpa.UserCouponJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class UserCouponRepositoryImpl implements IUserCouponRepository {

    private final UserCouponJpaRepository userCouponJpaRepository;

    @Override
    public List<UserCoupon> findAllByUserId(Long userId) {
        return userCouponJpaRepository.findAllByUserId(userId);
    }
}