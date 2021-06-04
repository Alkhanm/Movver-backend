package com.github.alkhanm.movver.domain.transference;

import com.github.alkhanm.movver.domain.Location;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class DriverResponse {
    @Getter private final long id;
    @Getter private final String name, phoneNumber;
    @Getter private final Location location;
    @Getter private final Boolean available;
    @Getter private final VehicleResponse vehicle;
    @Getter private final LocalDateTime birthdate;

    public DriverResponse(long id, String name, String phoneNumber, Location location, Boolean available, VehicleResponse vehicle, LocalDateTime birthdate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.available = available;
        this.vehicle = vehicle;
        this.birthdate = birthdate;
    }
}
