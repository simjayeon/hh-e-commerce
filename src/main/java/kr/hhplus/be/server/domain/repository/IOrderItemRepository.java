package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderItemRepository {

    void save(OrderItem orderItem);

    @Query("""
            SELECT oi FROM OrderItem oi
            JOIN FETCH oi.order
            JOIN FETCH oi.product
            WHERE oi.orderId = :orderId
            """)
    List<OrderItem> findAllByOrderId(@Param("orderId") Long orderId);
}
