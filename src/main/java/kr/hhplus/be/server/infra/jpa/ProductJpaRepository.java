package kr.hhplus.be.server.infra.jpa;

import kr.hhplus.be.server.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByIdIn(List<Long> ids);
}
