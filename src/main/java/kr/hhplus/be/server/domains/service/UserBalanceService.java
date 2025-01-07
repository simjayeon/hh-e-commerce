package kr.hhplus.be.server.domains.service;

import kr.hhplus.be.server.dto.request.RechargeBalanceRequest;
import kr.hhplus.be.server.dto.response.CouponResponse;
import kr.hhplus.be.server.dto.response.UserBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserBalanceService {

    public ResponseEntity<UserBalanceResponse> getUserBalance(Long userId) {
        return null;
    }

    public ResponseEntity<UserBalanceResponse> rechargeBalance(RechargeBalanceRequest req) {
        return null;
    }
}
