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
@Table(name = "`user_coupon`")
public final class UserCoupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "status")
    private String status;

    @Column(name = "used_at")
    private Timestamp usedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Coupon coupon;

}
