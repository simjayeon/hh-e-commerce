package kr.hhplus.be.server.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hhplus.be.server.ServerApplication;
import kr.hhplus.be.server.dto.response.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {ServerApplication.class})
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.profiles.active=local")
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
    }

    @WithMockUser(username = "testUser", roles = {"USER"})
    @Test
    void 상품목록조회_요청시_200_응답() throws Exception {
        // given
        ProductResponse product1 = new ProductResponse(1L, "상품1", 1000, 2);
        ProductResponse product2 = new ProductResponse(2L, "상품2", 2000, 1);
        List<ProductResponse> products = Arrays.asList(product1, product2);

        // when & then
        mockMvc.perform(get("/api/v1/products")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(products)))
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()))
                .andExpect(status().isOk());
    }

}
