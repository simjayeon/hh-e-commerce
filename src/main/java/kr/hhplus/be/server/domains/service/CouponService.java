package kr.hhplus.be.server.domains.service;

import kr.hhplus.be.server.dto.response.CouponResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    public ResponseEntity<List<CouponResponse>> getUserCoupons(Long userId) {
        return null;
    }

}
