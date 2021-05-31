package com.github.alkhanm.movver.domain;

import lombok.*;

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

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @Getter private Location location;

    @OneToOne(targetEntity = Vehicle.class, cascade = CascadeType.PERSIST)
    @Getter private Vehicle vehicle;

    public Driver(String name, String password, String phoneNumber, Long birthDate, boolean available, Location location, Vehicle vehicle) {
        super(name, password, phoneNumber, birthDate);
        this.available = available;
        this.location = location;
        this.vehicle = vehicle;
    }
}
