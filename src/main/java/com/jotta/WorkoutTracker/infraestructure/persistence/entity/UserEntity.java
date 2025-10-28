package com.jotta.WorkoutTracker.infraestructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "users") // Plural, PostgreSQL tiene palabra reservada "user"
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String provider;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    // TODO: anotación para validar email?
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "avatar_url", nullable = false)
    private String avatarUrl;

    @CreationTimestamp
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;
}
