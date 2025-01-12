package kr.hhplus.be.server.infra.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.hhplus.be.server.domain.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.hhplus.be.server.domain.entity.QOrderItem.orderItem;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    private final JPAQueryFactory queryFactory;

    public OrderItemRepositoryImpl() {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<OrderItem> findAllByUserIdAndOrderId(Long userId, Long orderId) {
        return queryFactory.selectFrom(orderItem)
                .where(orderItem.order.userId.eq(userId)
                        .and(orderItem.order.id.eq(orderId)))
                .fetch();
    }

    @Override
    public void save(OrderItem orderItem) {
        em.persist(orderItem);
    }

}