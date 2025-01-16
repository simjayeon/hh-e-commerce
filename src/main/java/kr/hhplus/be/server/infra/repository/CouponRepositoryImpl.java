package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.Coupon;
import kr.hhplus.be.server.domain.repository.ICouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
public class CouponRepositoryImpl implements ICouponRepository {

    @Override
    public void save(Coupon coupon) {

    }
}