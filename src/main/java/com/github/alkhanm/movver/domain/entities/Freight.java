package com.github.alkhanm.movver.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@Getter @ToString
@Table(name = "tb_freight")
public class Freight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String startDate;
    private String endDate;
    private Double price;
    private Double distance;

    @OneToOne @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.DELETE})
    private Location origin;

    @OneToOne @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.DELETE})
    private Location destination;

    @OneToOne
    private Client client;

    @OneToOne
    private Driver driver;

    public Freight() {}

    public Freight(Long id, String startDate, String endDate, Double price, Double distance,
                   Location origin, Location destination, Client client, Driver driver) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.distance = distance;
        this.origin = origin;
        this.destination = destination;
        this.client = client;
        this.driver = driver;
    }
}
