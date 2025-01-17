package kr.hhplus.be.server.domain.service;

import kr.hhplus.be.server.domain.entity.Product;
import kr.hhplus.be.server.domain.repository.IProductRepository;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
import kr.hhplus.be.server.support.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = TestcontainersConfiguration.class)
public class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("상품 목록 조회 테스트")
    void 상품목록_조회시_상품있으면_200_반환() {

        // Given
        int page = 1;
        int size = 10;

        List<Product> mockProducts = List.of(
                new Product(1L, "Product 1", 1000, 2),
                new Product(2L, "Product 2", 2000, 3)
        );

        Pageable pageable = PageRequest.of(page, size);
        when(productRepository.findAll(pageable)).thenReturn(new PageImpl<>(mockProducts));

        // When
        ResponseEntity<Page<ProductResponse>> response = productService.getProducts(pageable);

        // Then
        assertThat(response).isNotNull();
        verify(productRepository).findAll(pageable);
    }

    @Test
    @DisplayName("상품 없는 경우 테스트")
    void 상품목록_조회시_상품없으면_빈_Array_반환() {

        // Given
        int page = 1;
        int size = 10;

        Pageable pageable = PageRequest.of(page, size);
        when(productRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of()));

        // When
        ResponseEntity<Page<ProductResponse>> response = productService.getProducts(pageable);

        // Then
        assertThat(response.getBody()).isEqualTo(new PageImpl<>(List.of()));
        assertThat(response.getStatusCode()).isEqualTo((ErrorCode.NOT_FOUND.getStatus()));
        verify(productRepository).findAll(pageable);

    }

}
