package com.osipov.effectivemobileproject.repository;

import com.osipov.effectivemobileproject.model.History;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    boolean existsByUserIdAndProductId(Long userId, Long productId);

    List<History> findAllByUserId(Long userId, Pageable pageable);
}