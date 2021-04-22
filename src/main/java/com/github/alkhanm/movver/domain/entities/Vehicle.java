package com.github.alkhanm.movver.domain.entities;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="tb_vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id;
    @Getter private VehicleModelEnum model;
    @Getter private int capacity;
    @Getter private String licensePlate;
    @Getter private boolean truckBodyWorkOpen;
    @Getter private String color;
}
