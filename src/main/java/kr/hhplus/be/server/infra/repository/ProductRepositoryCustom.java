package kr.hhplus.be.server.infra.repository;

import kr.hhplus.be.server.domain.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> searchByPagination(int offset, int limit);

}
