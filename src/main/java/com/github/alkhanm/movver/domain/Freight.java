package com.github.alkhanm.movver.domain;

import com.github.alkhanm.movver.domain.strategies.FreightCalculator;
import com.github.alkhanm.movver.domain.strategies.HomeMovingCalculator;
import com.github.alkhanm.movver.domain.strategies.MaterialTransportCalculator;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
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
    @Getter
    private Long id;
    @Getter
    private String description;
    @Getter
    private int weight;
    @Getter
    private double distance;
    @Getter
    private double price;

    @Getter
    private LocalDateTime startDate;
    @Getter
    private LocalDateTime endDate;

    @Getter
    private FreightServiceEnum service;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    private Location origin;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    private Location destination;

    @Getter
    private FreightStatusEnum status = FreightStatusEnum.UNCONFIRMED;

    @OneToOne
    @Getter
    private Client client;
    @OneToOne
    @Getter
    private Driver driver;

    public Freight(Long id, Client client, Driver driver, Location origin, Location destination,
                   long startDate, long endDate, double distance, int weight,
                   FreightServiceEnum service, FreightStatusEnum status,
                   String description) {
        this.id = id;
        this.client = client;
        this.driver = driver;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.distance = distance;
        this.service = service;
        this.description = description;
        setEndDate(endDate);
        setStartDate(startDate);
    }

    public void calculatePrice() {
        FreightCalculator calculator = switch (service) {
            case HOME_MOVING -> new HomeMovingCalculator();
            case MATERIAL_TRANSPORT -> new MaterialTransportCalculator();
        };
        this.price = calculator.calculate(this);
    }

    public Freight confirm() {
        this.status = FreightStatusEnum.CONFIRMED;
        calculatePrice();
        return this;
    }

    public Freight start() {
        if (status != FreightStatusEnum.CONFIRMED)
            throw new RuntimeException("O frete ainda não foi confirmado");
        this.status = FreightStatusEnum.STARTED;
        return this;
    }

    public Freight finish() {
        if (status != FreightStatusEnum.STARTED)
            throw new RuntimeException("O frete ainda não foi iniciado");
        this.status = FreightStatusEnum.FINISHED;
        return this;
    }

    public Freight cancel() {
        if (status != FreightStatusEnum.CONFIRMED)
            throw new RuntimeException("O frete ainda não pode ser cancelado no atual estado");
        this.status = FreightStatusEnum.CANCELED;
        return this;
    }


    public void setStartDate(long startDate) {
        this.startDate = DateUtil.millisecondsToDate(startDate);
    }

    public void setEndDate(long endDate) {
        this.endDate = DateUtil.millisecondsToDate(endDate);
    }

}