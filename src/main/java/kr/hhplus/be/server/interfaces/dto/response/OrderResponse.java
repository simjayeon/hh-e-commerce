package kr.hhplus.be.server.interfaces.dto.response;

import kr.hhplus.be.server.domain.entity.OrderItem;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public record OrderResponse(
        Long orderId,
        Date orderedAt,
        Long userId,
        String userName,
        List<ProductResponse> products
) {

    public static OrderResponse of(OrderItem orderItem, List<ProductResponse> productResponses) {
        return OrderResponse.builder()
                .orderId(orderItem.getOrder().getId())
                .orderedAt(orderItem.getCreatedAt())
                .userId(orderItem.getOrder().getUser().getId())
                .userName(orderItem.getOrder().getUser().getName())
                .products(productResponses)
                .build();
    }
}
