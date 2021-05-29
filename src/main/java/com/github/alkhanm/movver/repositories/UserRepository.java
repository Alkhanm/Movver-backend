package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    T findByPhoneNumber(String phoneNumber);
}
