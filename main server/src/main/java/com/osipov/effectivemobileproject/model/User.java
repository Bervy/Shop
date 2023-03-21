package com.osipov.effectivemobileproject.model;

import com.osipov.effectivemobileproject.enums.AccountStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"id", "name", "email"})
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "email", length = 64, unique = true)
    private String email;
    @NotNull
    @Column(name = "password")
    private String password;
    @NotNull
    @Builder.Default
    @Column(name = "balance")
    private Double balance = 0.0;
    @NotNull
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private AccountStatus accountStatus = AccountStatus.ACTIVE;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}