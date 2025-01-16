package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductRepository {

    Page<Product> findAll(Pageable pageable);

    List<Product> findAllByIdIn(List<Long> ids);
}
