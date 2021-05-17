package com.github.alkhanm.movver.domain.entities.transference;

import com.github.alkhanm.movver.domain.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class DriverResponse {
    @Getter final long id;
    @Getter final String name;
    @Getter final String phoneNumber;
    @Getter final LocalDateTime birthDate;
    @Getter final String location;
    @Getter final boolean available;
    @Getter final VehicleResponse vehicle;
}
