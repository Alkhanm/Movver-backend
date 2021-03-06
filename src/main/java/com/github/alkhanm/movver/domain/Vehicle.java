package com.github.alkhanm.movver.domain;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.domain.enums.VehicleTruckBodyEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="tb_vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id;
    private VehicleModelEnum model;
    @Getter private int capacity;
    @Getter private String licensePlate;
    @Getter private VehicleTruckBodyEnum truckBodyWork;
    @Getter private String color;

    public String getModel() {
        return model.toString();
    }
}
