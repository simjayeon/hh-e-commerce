package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.Order;
import kr.hhplus.be.server.domain.repository.IOrderRepository;
import kr.hhplus.be.server.infra.jpa.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements IOrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public List<Order> findAllByUserIdAndOrderById(Long userId, Long orderId) {
        return orderJpaRepository.findAllByUserIdAndId(userId, orderId);
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderJpaRepository.save(order);
    }

}