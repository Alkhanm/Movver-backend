package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    @Query("SELECT u FROM User u WHERE u.id = ?1 OR u.phoneNumber = ?1")
    Optional<T> findByIdOrPhoneNumber(Long identification);

    Optional<T> findByPhoneNumber(String phoneNumber);

}
