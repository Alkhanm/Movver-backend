package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.entities.Credentials;
import com.github.alkhanm.movver.domain.entities.User;
import com.github.alkhanm.movver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatorService implements UserDetailsService {
    private final UserRepository<User> repository;

    //Pega o codificador padrão
    private final PasswordEncoder encoder;

    public AuthenticatorService(UserRepository<User> repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override public UserDetails loadUserByUsername(String phoneNumber)  {
        User user = repository.findByPhoneNumber(phoneNumber);
        if (user == null) throw new UsernameNotFoundException("Usuário não encontrado");
        return user;
    }
    public User authenticate(Credentials credentials){
        User user = (User) loadUserByUsername(credentials.phoneNumber());
        boolean isValid = encoder.matches(credentials.password(), user.getPassword());
        if (isValid) return user;
        throw new InvalidCredentialsException();
    }
}
