package com.github.alkhanm.movver.domain;

import com.github.alkhanm.movver.domain.design.patterns.states.FreightStatus;
import com.github.alkhanm.movver.domain.design.patterns.states.FreightUnconfirmedStatus;
import com.github.alkhanm.movver.domain.design.patterns.strategies.HomeMovingCalculator;
import com.github.alkhanm.movver.domain.design.patterns.strategies.MaterialTransportCalculator;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.utils.DateUtil;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode
@ToString
@Table(name = "tb_freight")
@NoArgsConstructor
@AllArgsConstructor
public class Freight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id;
    @Getter private String description;
    @Getter private int weight = 0;
    @Getter private double distance = 0.0;
    @Getter private LocalDateTime startDate, endDate;
    @Getter private FreightServiceEnum service;

    @Getter private double price;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Getter private Location origin, destination;

    @OneToOne @Getter private Client client;
    @OneToOne @Getter private Driver driver;

    @Transient
    private FreightStatus status = new FreightUnconfirmedStatus(this);

    public Freight(Client client) {
        this.client = client;
    }

    public Freight(
            Client client, Driver driver,
            Location origin, Location destination,
            long startDate, long endDate,
            double distance,
            int weight,
            FreightServiceEnum service) {
        this.client = client;
        this.driver = driver;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        setEndDate(endDate);
        setStartDate(startDate);
        this.distance = distance;
        this.service = service;
    }



    public void calculatePrice() {
        this.price = switch (service) {
            case HOME_MOVING -> new HomeMovingCalculator().calculate(this);
            case MATERIAL_TRANSPORT -> new MaterialTransportCalculator().calculate(this);
        };
    }

    public void confirm() {
        status.confirm();
    }
    public void start() {
        status.start();
    }
    public void finish() {
        status.finish();
    }
    public void cancel() {
        status.cancel();
    }

    public void setStartDate(long startDate) {
        this.startDate = DateUtil.millisecondsToDate(startDate);
    }
    public void setEndDate(long endDate) {
        this.endDate = DateUtil.millisecondsToDate(endDate);
    }

}