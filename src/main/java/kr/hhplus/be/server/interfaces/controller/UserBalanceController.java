package kr.hhplus.be.server.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.domain.service.UserBalanceService;
import kr.hhplus.be.server.interfaces.dto.request.RechargeBalanceRequest;
import kr.hhplus.be.server.interfaces.dto.response.UserBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/balance")
@RequiredArgsConstructor
public class UserBalanceController {

    private final UserBalanceService userBalanceService;

    @GetMapping("/{userId}")
    @Operation(summary = "getUserBalance", description = "사용자 잔액 조회")
    public ResponseEntity<UserBalanceResponse> getUserBalance(@PathVariable Long userId) {
        return userBalanceService.getUserBalance(userId);
    }

    @PostMapping("")
    @Operation(summary = "rechargeBalance", description = "사용자 잔액 충전")
    public ResponseEntity<UserBalanceResponse> rechargeBalance(@RequestBody RechargeBalanceRequest req) {
        return userBalanceService.rechargeBalance(req);
    }

}
