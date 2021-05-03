package com.github.alkhanm.movver.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

@
        Entity
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    protected long id;

    @NotEmpty(message = "O nome não pode estar vazio")
    @Column(nullable = false)
    @Getter protected String name;

    @NotEmpty(message = "O número de telefone não pode estar vazio")
    @Column(nullable = false, unique = true)
    @Getter protected String phoneNumber;

    @JsonIgnore
    @Column(nullable = false)
    @Getter protected String password;

    @Column(nullable = false)
    @Getter protected LocalDateTime birthDate;

    @JsonIgnore @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @JsonIgnore @Override public String getUsername() {
        return this.phoneNumber;
    }
    @JsonIgnore @Override public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore @Override public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore @Override public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore @Override public boolean isEnabled() {
        return true;
    }
}
