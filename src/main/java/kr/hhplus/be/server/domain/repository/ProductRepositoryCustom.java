package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> searchByPagination(int offset, int limit);

}
