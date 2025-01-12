package kr.hhplus.be.server.infra.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import kr.hhplus.be.server.domain.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.hhplus.be.server.domain.entity.QProduct.product;


@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> searchByPagination(int offset, int limit) {
        return queryFactory.selectFrom(product)
                .where(product.quantity.lt(0))
                .offset(offset)
                .limit(limit)
                .fetch();
    }

}