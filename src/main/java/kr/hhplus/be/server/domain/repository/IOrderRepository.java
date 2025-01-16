package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.Order;

import java.util.List;

public interface IOrderRepository {

    List<Order> findAllByUserIdAndOrderById(Long userId, Long orderId);

    void save(Order order);

}
