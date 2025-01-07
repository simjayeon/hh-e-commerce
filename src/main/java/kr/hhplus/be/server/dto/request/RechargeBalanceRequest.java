package kr.hhplus.be.server.dto.request;


public record RechargeBalanceRequest(
        Long userId,
        Integer rechargeAmount
) {
}
