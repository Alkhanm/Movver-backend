package com.github.alkhanm.movver.domain.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
@Table(name = "tb_driver")
public class Driver extends User {
    @Getter private boolean available;
    @Getter private String location;

    @OneToOne(targetEntity = Vehicle.class, cascade = CascadeType.PERSIST)
    @Getter private Vehicle vehicle;
}
