package kr.hhplus.be.server.domain.entity;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.sql.Timestamp;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = TestcontainersConfiguration.class)
public class OrderTest {

    @Test
    @DisplayName("주문 생성 테스트")
    void createOrder() {

        Order order = new Order();
        order.setUserId(1L);
        order.setTotalAmount(2000);
        order.setQuantity(2);
        order.setOrderedAt(new Timestamp(System.currentTimeMillis()));

        assertThat(order.getId()).isNull();
        assertThat(order.getUserId()).isEqualTo(1L);
        assertThat(order.getTotalAmount()).isEqualTo(2000);
        assertThat(order.getQuantity()).isEqualTo(2);

    }

}
