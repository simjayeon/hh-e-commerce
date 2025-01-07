package kr.hhplus.be.server.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.entity.common.BaseEntity;
import lombok.Getter;

import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "ordered_at")
    private Timestamp orderedAt;

}
