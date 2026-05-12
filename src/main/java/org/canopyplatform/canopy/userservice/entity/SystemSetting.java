package org.canopyplatform.canopy.userservice.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Generic key/value row for platform-wide settings. The `value` column is a
 * JSONB blob whose shape is defined per key by the application layer (see
 * {@code SystemSettingKey} and the typed DTOs in {@code dto}).
 */
@Entity
@Table(name = "system_setting")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemSetting {

    @Id
    @Column(name = "key")
    private String key;

    @Column(name = "value", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private String value;

    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Column(name = "updated_by_user_id")
    private Integer updatedByUserId;

    @PrePersist
    @PreUpdate
    public void touch() {
        this.updatedAt = ZonedDateTime.now();
    }
}
