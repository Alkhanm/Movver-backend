package com.github.alkhanm.movver.domain.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
@Table(name = "tb_driver")
public class Driver extends User {
    @Getter private boolean available;
    @Getter private String location;

    @OneToOne(targetEntity = Vehicle.class, cascade = CascadeType.PERSIST)
    @Getter private Vehicle vehicle;

    public Driver(String name, String password, String phoneNumber, LocalDateTime birthDate, boolean available, String location, Vehicle vehicle) {
        super(name, password, phoneNumber, birthDate);
        this.available = available;
        this.location = location;
        this.vehicle = vehicle;
    }
}
