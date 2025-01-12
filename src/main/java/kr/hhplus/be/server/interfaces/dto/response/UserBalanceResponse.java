package kr.hhplus.be.server.interfaces.dto.response;


import kr.hhplus.be.server.interfaces.dto.enumeration.BalanceStatus;

import java.util.Date;

public record UserBalanceResponse(
        Long userId,
        Integer balance,
        BalanceStatus status,
        Date createdAt
) {
}
