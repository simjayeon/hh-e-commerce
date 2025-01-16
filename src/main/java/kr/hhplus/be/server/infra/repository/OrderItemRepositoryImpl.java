package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.OrderItem;
import kr.hhplus.be.server.domain.repository.IOrderItemRepository;
import kr.hhplus.be.server.infra.jpa.OrderItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements IOrderItemRepository {

    private final OrderItemJpaRepository orderItemJpaRepository;

    @Override
    public void save(OrderItem orderItem) {
        orderItemJpaRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> findAllByOrderId(Long orderId) {
        return orderItemJpaRepository.findAllByOrderId(orderId);
    }

}