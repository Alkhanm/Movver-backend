package com.github.alkhanm.movver.domain;

import com.github.alkhanm.movver.configurations.Instantiation;
import com.github.alkhanm.movver.domain.design.patterns.states.FreightState;
import com.github.alkhanm.movver.domain.design.patterns.states.FreightUnconfirmedState;
import com.github.alkhanm.movver.domain.design.patterns.strategies.FreightCalculator;
import com.github.alkhanm.movver.domain.design.patterns.strategies.HomeMovingCalculator;
import com.github.alkhanm.movver.domain.design.patterns.strategies.MaterialTransportCalculator;
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
    @Getter private long id;
    @Getter private String description;
    @Getter private int weight;
    @Getter private double distance;
    @Getter private double price;

    @Getter private LocalDateTime startDate;
    @Getter private LocalDateTime endDate;

    @Getter private FreightServiceEnum service;
    @Getter private FreightStatusEnum status;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter private Location origin;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter private Location destination;

    @OneToOne @Getter private Client client;
    @OneToOne @Getter private Driver driver;

    @Transient
    private FreightState state = new FreightUnconfirmedState(this);

    public Freight(long id, Client client, Driver driver, Location origin, Location destination,
                   long startDate, long endDate, double distance, int weight,
                   FreightServiceEnum service,
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
        this.status = state.getName();
    }

    public void calculatePrice() {
        FreightCalculator calculator = switch (service) {
            case HOME_MOVING -> new HomeMovingCalculator();
            case MATERIAL_TRANSPORT -> new MaterialTransportCalculator();
        };
        this.price = calculator.calculate(this);
    }

    public Freight confirm() {
        state.confirm();
        return this;
    }
    public Freight start() {
        state.start();
        return this;
    }
    public Freight finish() {
        state.finish();
        return this;
    }
    public Freight cancel() {
        state.cancel();
        return this;
    }

    public void setState(FreightState state) {
        System.out.print(this.status.getClass().getSimpleName());
        this.state = state;
        this.status = state.getName();
        System.out.print(" -> " +this.status.getClass().getSimpleName() + "\n");
        System.out.println(this);
        System.out.println("------------------------------------------");
    }

    public void setStartDate(long startDate) {
        this.startDate = DateUtil.millisecondsToDate(startDate);
    }

    public void setEndDate(long endDate) {
        this.endDate = DateUtil.millisecondsToDate(endDate);
    }

    public static void main(String[] args) {
        Freight freight = Instantiation.freights.get(0);
        freight.calculatePrice();
        System.out.println(freight.price);

        Freight freight2 = Instantiation.freights.get(1);
        freight2.calculatePrice();
        System.out.println(freight2.price);

        //Ordem certa
        System.out.println("confirm - start - finish");
        freight.confirm().start().finish();

        //Resulta em erro
        System.out.println("start - confirm - finish");
        freight.start().confirm().finish();

        //Resulta em erro
        System.out.println("finish - confirm - start - cancel");
        freight.finish().confirm().start().cancel();
    }
}