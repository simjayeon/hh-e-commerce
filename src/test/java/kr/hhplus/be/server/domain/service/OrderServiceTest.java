package kr.hhplus.be.server.domain.service;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.entity.Order;
import kr.hhplus.be.server.domain.entity.OrderItem;
import kr.hhplus.be.server.domain.entity.Product;
import kr.hhplus.be.server.domain.entity.User;
import kr.hhplus.be.server.domain.repository.IOrderRepository;
import kr.hhplus.be.server.interfaces.dto.enumeration.OrderStatus;
import kr.hhplus.be.server.interfaces.dto.response.OrderResponse;
import kr.hhplus.be.server.interfaces.dto.response.ProductResponse;
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

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TestcontainersConfiguration.class)
public class OrderServiceTest {

    @Mock
    private IOrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    User user;

    public void setUp() {
        user = new User(1L, "Nature", "nature@email.com", "qwer1234");
    }

    @Test
    @DisplayName("주문 조회 테스트")
    void 주문목록_조회시_있으면_200_반환() {

        setUp();

        List<Product> mockProducts = List.of(
                new Product(1L, "Product 1", 1000, 2),
                new Product(2L, "Product 2", 2000, 3)
        );

        List<OrderItem> mockOrderItems = List.of(
                new OrderItem(1L, 1L, 1L, 2, 2000, null, mockProducts.get(0)),
                new OrderItem(2L, 2L, 2L, 3, 6000, null, mockProducts.get(1))
        );

        // Given
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Order mockOrders = new Order(1L, 1L, 2000, 2, OrderStatus.WAITING.name(), timestamp, user);

        when(orderRepository.findAllByUserIdAndOrderById(1L, 1L)).thenReturn(List.of(mockOrders));

        // When
        ResponseEntity<OrderResponse> response = orderService.getOrders(user.getId(), mockOrders.getId());

        // Then
        assertThat(response).isNotNull();
        verify(orderRepository).findAllByUserIdAndOrderById(1L, 1L);
    }

}
