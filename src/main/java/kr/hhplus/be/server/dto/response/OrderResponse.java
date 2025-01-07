package kr.hhplus.be.server.dto.response;


import java.util.Date;
import java.util.List;

public record OrderResponse(
        Long orderId,
        Date orderedAt,
        Long userId,
        String userName,
        List<ProductResponse> products
) {
}
