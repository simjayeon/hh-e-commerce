package kr.hhplus.be.server.domains.service;

import kr.hhplus.be.server.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    // TODO : 페이지네이션 고려
    public ResponseEntity<ProductResponse> getProducts() {
        return null;
    }

    public ResponseEntity<ProductResponse> getTop5Products() {
        return null;
    }
}
