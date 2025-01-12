package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.Order;

import java.util.List;

public interface OrderRepositoryCustom {

    List<Order> findByUserIdAndOrderId(Long userId, Long orderId);

    void save(Order order);

}
