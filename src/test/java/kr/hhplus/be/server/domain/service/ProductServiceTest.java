package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Test
    @DisplayName("상품 목록 조회 테스트")
    void searchProducts() {
        // given
        ProductResponse product1 = new ProductResponse(1L, "상품1", 1000, 2);
        ProductResponse product2 = new ProductResponse(2L, "상품2", 2000, 1);
        List<ProductResponse> products = Arrays.asList(product1, product2);

        // when & then
    }


}
