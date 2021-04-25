package com.github.alkhanm.movver.domain.entities.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.alkhanm.movver.domain.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DriverRequest {
    @Getter final String name;
    @Getter final String location;
    @Getter final boolean available;
    @Getter final String phoneNumber;
    @Getter final String password;
    @Getter final VehicleRequest vehicle;
}
