package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.domain.repository.IProductRepository;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import kr.hhplus.be.server.domain.entity.Product;
import kr.hhplus.be.server.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;

    public ResponseEntity<Page<ProductResponse>> getProducts(Pageable pageable) {        // 상품 조회
        Page<Product> products = productRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        // 상품이 없을 경우 예외 처리
        if (products.isEmpty()) {
            return ResponseEntity.status(ErrorCode.NOT_FOUND.getStatus()).body(new PageImpl<>(List.of()));
        }
        return ResponseEntity.ok(products.map(ProductResponse::of));
    }


    public ResponseEntity<List<ProductResponse>> getTop5Products() {
        // TODO : 인기 상품 조회 로직 추가

        return null;
    }
}
