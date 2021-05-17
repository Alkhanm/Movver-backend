package com.github.alkhanm.movver.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@ToString
@NoArgsConstructor
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    protected long id;

    @NotEmpty(message = "O nome não pode estar vazio")
    @Column(nullable = false)
    @Getter
    protected String name;

    @NotEmpty(message = "O número de telefone não pode estar vazio")
    @Column(nullable = false, unique = true)
    @Getter protected String phoneNumber;

    @Column(nullable = false)
    @Getter protected String password;

//    @Column(nullable = false)
    @Getter protected LocalDateTime birthday;

    public User(String name, String password, String phoneNumber, LocalDateTime birthday) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public final User toSave(PasswordEncoder encoder){
        this.password = encoder.encode(password);
        this.phoneNumber = removePhoneMask(this.phoneNumber);
        return this;
    }

    public static String removePhoneMask(String phoneNumber){
        //Remove tudo que ñ for numérico
        return phoneNumber.replaceAll("[^0-9]", "");
    }

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
