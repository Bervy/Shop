package com.osipov.effectivemobileproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.osipov.effectivemobileproject.enums.PayStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(of = {"id", "user", "product"})
@EqualsAndHashCode(of = {"id", "user", "product"})
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @Builder.Default
    @Column(name = "date_of_purchase")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfPurchase = LocalDateTime.now();
    @Builder.Default
    @Column(name = "status")
    private PayStatus status = PayStatus.CONFIRMED;
}