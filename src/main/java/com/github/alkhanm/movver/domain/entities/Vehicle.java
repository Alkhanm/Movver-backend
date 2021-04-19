package com.github.alkhanm.movver.domain.entities;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name ="tb_vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private VehicleModelEnum model;
    private Integer capacity;
    private String licensePlate;
    private Boolean truckBodyWorkOpen;
    private String color;
}
