package com.github.alkhanm.movver.domain.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Table(name = "tb_driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id;
    @Getter private String name;
    @Getter private String phoneNumber;
    @Getter private String password;
    @Getter private boolean available;
    @Getter private String location; // latitude: 1.057, longitude: 1.0024

    @OneToOne(targetEntity = Vehicle.class, cascade = CascadeType.PERSIST)
    @Getter private Vehicle vehicle;
}
