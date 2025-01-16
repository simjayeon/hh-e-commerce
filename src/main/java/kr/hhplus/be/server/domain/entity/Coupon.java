package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "`coupon`")
public final class Coupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "issued_quantity")
    private Integer issuedQuantity;

    @Column(name = "max_quantity")
    private Integer maxQuantity;

    @Column(name = "start_at")
    private Timestamp startAt;

    @Column(name = "end_at")
    private Timestamp endAt;

}
