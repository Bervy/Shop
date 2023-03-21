package com.osipov.effectivemobileproject.repository;

import com.osipov.effectivemobileproject.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
