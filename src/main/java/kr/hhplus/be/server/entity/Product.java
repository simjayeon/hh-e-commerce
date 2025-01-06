package kr.hhplus.be.server.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.entity.common.BaseEntity;
import lombok.Getter;

@Entity
@Getter
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private Integer quantity;

}
