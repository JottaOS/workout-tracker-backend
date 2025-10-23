package com.jotta.WorkoutTracker.infraestructure.persistence.entity;

import com.jotta.WorkoutTracker.shared.ExerciseType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "exercise")
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExerciseType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "muscle_id", nullable = false)
    private Muscle muscle;
}
