package com.github.alkhanm.movver.domain.transference;

import com.github.alkhanm.movver.domain.Location;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class FreightResponse {
    @Getter private final long id;
    @Getter private final String description;
    @Getter private final int weight;
    @Getter private final double distance;
    @Getter private final LocalDateTime startDate, endDate;
    @Getter private final FreightServiceEnum service;
    @Getter private final FreightStatusEnum status;
    @Getter private final double price;
    @Getter private final Location origin, destination;
    @Getter private final ClientResponse client;
    @Getter private final DriverResponse driver;

    public FreightResponse(long id, String description, int weight, double distance,
                           LocalDateTime startDate, LocalDateTime endDate, FreightServiceEnum service,
                           FreightStatusEnum status, double price, Location origin, Location destination,
                           ClientResponse client, DriverResponse driver) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.distance = distance;
        this.startDate = startDate;
        this.endDate = endDate;
        this.service = service;
        this.status = status;
        this.price = price;
        this.origin = origin;
        this.destination = destination;
        this.client = client;
        this.driver = driver;
    }
}
