package kr.hhplus.be.server.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Embeddable
@Data
@MappedSuperclass
public abstract class BaseEntity {

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private Timestamp updatedAt;
}
