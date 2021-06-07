package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.transference.Credentials;
import com.github.alkhanm.movver.domain.User;
import com.github.alkhanm.movver.repositories.UserRepository;
import com.github.alkhanm.movver.services.exceptions.InvalidCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatorService implements UserDetailsService {
    private final UserRepository<?> repository;

    //Pega o codificador padrão
    private final PasswordEncoder encoder;

    public AuthenticatorService(UserRepository<User> repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override public UserDetails loadUserByUsername(String phoneNumber)  {
        User user = repository.findByPhoneNumber(User.removePhoneMask(phoneNumber));
        if (user == null) throw new InvalidCredentialsException();
        return user;
    }

    public User authenticate(Credentials credentials){
        User user = (User) loadUserByUsername(credentials.getPhoneNumber());
        boolean isValid = encoder.matches(credentials.getPassword(), user.getPassword());
        if (isValid) return user;
        throw new InvalidCredentialsException();
    }

    public User getUserAuthenticated(){
        Authentication userAuthenticated = SecurityContextHolder.getContext().getAuthentication();
        return (User) userAuthenticated.getPrincipal();
    }
}
