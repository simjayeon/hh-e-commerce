package kr.hhplus.be.server.domains.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.domains.service.ProductService;
import kr.hhplus.be.server.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // TODO : 페이지네이션 고려
    @GetMapping("")
    @Operation(summary = "getProducts", description = "상품 목록 조회")
    public ResponseEntity<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/top5")
    @Operation(summary = "getTop5Products", description = "인기 상품 목록 조회")
    public ResponseEntity<ProductResponse> getTop5Products() {
        return productService.getTop5Products();
    }

}
