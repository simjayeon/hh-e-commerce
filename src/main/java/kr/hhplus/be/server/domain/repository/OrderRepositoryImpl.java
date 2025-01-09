package kr.hhplus.be.server.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.hhplus.be.server.entity.Order;
import kr.hhplus.be.server.entity.OrderItem;
import kr.hhplus.be.server.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.hhplus.be.server.entity.QOrder.order;
import static kr.hhplus.be.server.entity.QProduct.product;


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