package kr.hhplus.be.server.infra.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.hhplus.be.server.domain.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.hhplus.be.server.domain.entity.QOrder.order;


@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl() {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Order> findByUserIdAndOrderId(Long userId, Long orderId) {
        return queryFactory.selectFrom(order)
                .where(order.userId.eq(userId).and(order.id.eq(orderId)))
                .fetch();
    }

    @Override
    public void save(Order order) {
        em.persist(order);
    }

}