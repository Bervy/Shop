package com.osipov.effectivemobileproject.repository;

import com.osipov.effectivemobileproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "" +
            "UPDATE users " +
            "SET balance = balance + ?2 " +
            "WHERE id = ?1", nativeQuery = true)
    void raiseBalance(Long userId, Double balance);

    @Modifying(clearAutomatically = true)
    @Query(value = "" +
            "UPDATE users " +
            "SET account_status = ?2 " +
            "WHERE id = ?1", nativeQuery = true)
    void userSetStatus(Long userId, String accountStatus);
}