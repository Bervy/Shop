package com.osipov.effectivemobileproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(of = {"id", "text"})
@EqualsAndHashCode(of = {"id", "text"})
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "header", length = 64)
    private String header;
    @NotNull
    @Column(name = "text", length = 255)
    private String text;
    @Column(name = "date_of_creation", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dateOfCreation;
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "users")
    private User user;
}