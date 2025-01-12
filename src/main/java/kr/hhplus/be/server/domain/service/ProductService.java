package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.infra.repository.ProductRepositoryImpl;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import kr.hhplus.be.server.domain.entity.Product;
import kr.hhplus.be.server.support.exception.ErrorCode;
import kr.hhplus.be.server.support.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepositoryImpl productRepositoryImpl;

    public ResponseEntity<List<ProductResponse>> getProducts(int page, int size) {

        // 상품 조회
        int offset = page * size;
        List<Product> products = productRepositoryImpl.searchByPagination(offset, size);

        // 상품이 없을 경우 예외 처리
        if (products.isEmpty()) {
            throw new NotFoundException(ErrorCode.NOT_FOUND.getMessage());
        }

        // Entity > DTO 변환
        List<ProductResponse> responses = products.stream()
                .map(ProductResponse::of)
                .toList();

        return ResponseEntity.ok(responses);
    }

    public ResponseEntity<List<ProductResponse>> getTop5Products() {
        // TODO : 인기 상품 조회 로직 추가

        return null;
    }
}
