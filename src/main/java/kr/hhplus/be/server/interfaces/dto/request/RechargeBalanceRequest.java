package kr.hhplus.be.server.interfaces.dto.request;


public record RechargeBalanceRequest(
        Long userId,
        Integer rechargeAmount
) {
}
