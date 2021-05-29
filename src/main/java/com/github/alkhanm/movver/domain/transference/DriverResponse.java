package com.github.alkhanm.movver.domain.transference;

import com.github.alkhanm.movver.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@ToString
public class DriverResponse {
    @Getter final long id;
    @Getter final String name, phoneNumber;
    @Getter final Location location;
    @Getter final Boolean available;
    @Getter final VehicleResponse vehicle;
    @Getter final LocalDateTime birthdate;
}
