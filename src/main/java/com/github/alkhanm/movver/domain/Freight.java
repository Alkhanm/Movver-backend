package com.github.alkhanm.movver.domain;

import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@Getter @ToString
@Table(name = "tb_freight")
public class Freight {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String startDate;
    private String endDate;
    private int weight = 0;
    private double price = 50.00, distance = 0.0;
    private String description;

    private FreightStatusEnum status;
    private FreightServiceEnum service;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private Location origin;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private Location destination;

    @OneToOne
    private Client client;

    @OneToOne
    private Driver driver;

    public Freight() {}

    public Freight(
            String startDate, String endDate, double distance,
            FreightStatusEnum status, FreightServiceEnum service, int weight,
            double price, String description, Location origin, Location destination,
            Client client, Driver driver) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.distance = distance;
        this.status = status;
        this.service = service;
        this.weight = weight;
        this.price = price;
        this.description = description;
        this.origin = origin;
        this.destination = destination;
        this.client = client;
        this.driver = driver;
    }
}
