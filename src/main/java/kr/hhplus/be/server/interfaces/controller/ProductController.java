package kr.hhplus.be.server.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.domain.service.ProductService;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    @Operation(summary = "getProducts", description = "상품 목록 조회")
    public ResponseEntity<List<ProductResponse>> getProducts(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size) {
        return productService.getProducts(page, size);
    }

    @GetMapping("/top5")
    @Operation(summary = "getTop5Products", description = "인기 상품 목록 조회")
    public ResponseEntity<List<ProductResponse>> getTop5Products() {
        return productService.getTop5Products();
    }

}
