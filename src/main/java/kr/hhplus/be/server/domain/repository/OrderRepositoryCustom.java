package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.entity.Order;

import java.util.List;

public interface OrderRepositoryCustom {

    List<Order> findByUserIdAndOrderId(Long userId, Long orderId);

    void save(Order order);

}
