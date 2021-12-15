package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.Driver;
import com.github.alkhanm.movver.domain.User;

import java.util.List;

public interface UserService<T extends User> {
    List<T> findAllBy();
    T findByPhoneNumber(String phoneNumber);
    T save(T user);

    T update(long id, T user);

    void delete(Long identification);
}
