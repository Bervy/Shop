package com.osipov.effectivemobileproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(of = {"id", "text"})
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Product product;
    @NotNull
    @NotBlank()
    @Column(name = "text")
    private String text;
    @NotNull
    @Min(value = -10)
    @Max(value = 10)
    @Column(name = "rating")
    private Integer rating;
}