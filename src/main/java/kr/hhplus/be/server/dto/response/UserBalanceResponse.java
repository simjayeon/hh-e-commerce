package kr.hhplus.be.server.dto.response;


import kr.hhplus.be.server.dto.enumeration.BalanceStatus;

import java.util.Date;
import java.util.List;

public record UserBalanceResponse(
        Long userId,
        Integer balance,
        BalanceStatus status,
        Date createdAt
) {
}
