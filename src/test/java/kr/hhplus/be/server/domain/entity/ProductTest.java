package kr.hhplus.be.server.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.utility.TestcontainersConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = TestcontainersConfiguration.class)
public class ProductTest {

    @Test
    @DisplayName("상품 생성 테스트")
    void createProduct() {
        String name = "상품1";
        Integer price = 1000;
        Integer quantity = 2;

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        assertThat(product.getId()).isNull();
        assertThat(product.getName()).isNotNull();
        assertThat(product.getPrice()).isNotNull();
        assertThat(product.getQuantity()).isNotNull();
    }

}
