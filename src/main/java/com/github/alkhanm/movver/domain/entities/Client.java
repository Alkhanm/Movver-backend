package com.github.alkhanm.movver.domain.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.core.codec.Encoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_client")
public class Client extends User {
    public Client() {}
    public Client(String name, String password, String phoneNumber, LocalDateTime birthDate) {
        super(name, password, phoneNumber, birthDate);
    }
}