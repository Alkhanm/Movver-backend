package com.github.alkhanm.movver.domain.entities.transference;

import com.github.alkhanm.movver.domain.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @ToString
public class DriverResponse {
    final long id;
    final String name, phoneNumber, location;
    final Boolean available;
    final LocalDateTime birthDate;
    final VehicleResponse vehicle;
}
