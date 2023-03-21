package com.osipov.effectivemobileproject.model;

import com.osipov.effectivemobileproject.enums.OrganizationStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.net.URI;

@Entity
@Table(name = "organization")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name", unique = true)
    private String name;
    @NotNull
    @Column(name = "description")
    private String description;
    @Transient
    private URI logo;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator", referencedColumnName = "id")
    private User creator;
    @NotNull
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "organization_status", referencedColumnName = "id")
    private OrganizationStatus organizationStatus = OrganizationStatus.PENDING;
}