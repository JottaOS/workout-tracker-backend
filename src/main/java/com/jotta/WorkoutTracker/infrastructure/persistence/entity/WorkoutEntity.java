package com.jotta.WorkoutTracker.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "workout")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column
    private Short sets;

    @Column
    private Integer volume;

    @Column(name = "started_at", nullable = false, updatable = false)
    private ZonedDateTime startedAt;

    @Column(name = "finished_at", nullable = false, updatable = false)
    private ZonedDateTime finishedAt;

    @OneToMany(
            mappedBy = "workout",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,  // Propagar insert update delete
            orphanRemoval = true        // Eliminar de la BD cualquier registro que quite de mi lista
    )
    private List<WorkoutExerciseEntity> exercises = new ArrayList<>();

    // TODO: agregar cuando se implemente el auth
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private UserEntity user;
}
