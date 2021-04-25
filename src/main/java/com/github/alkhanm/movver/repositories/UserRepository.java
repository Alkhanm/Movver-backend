package com.github.alkhanm.movver.repositories;

import com.github.alkhanm.movver.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    T findByPhoneNumber(String phoneNumber);
}
