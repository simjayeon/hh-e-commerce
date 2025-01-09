package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.dto.request.RechargeBalanceRequest;
import kr.hhplus.be.server.dto.response.UserBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
