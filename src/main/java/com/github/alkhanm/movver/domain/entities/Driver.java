package com.github.alkhanm.movver.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String location; // latitude: 1.057, longitude: 1.002
    private boolean available;

    private String phoneNumber;
    private String password;

    @OneToOne(targetEntity = Vehicle.class, cascade = CascadeType.PERSIST)
    private Vehicle vehicle;
}
