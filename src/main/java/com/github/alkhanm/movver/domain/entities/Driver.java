package com.github.alkhanm.movver.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "tb_driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String phoneNumber;
    private String password;

    private boolean available;
    private String location; // latitude: 1.057, longitude: 1.0024



    @OneToOne(targetEntity = Vehicle.class, cascade = CascadeType.PERSIST)
    private Vehicle vehicle;

}
