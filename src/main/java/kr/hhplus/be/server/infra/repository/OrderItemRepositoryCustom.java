package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.OrderItem;

import java.util.List;

public interface OrderItemRepositoryCustom {

    List<OrderItem> findAllByUserIdAndOrderId(Long userId, Long orderId);

    void save(OrderItem orderItem);

}
