package com.github.alkhanm.movver.domain.entities.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DriverResponse {
    @JsonSerialize final long id;
    @JsonSerialize final String name;
    @JsonSerialize final String location;
    @JsonSerialize final boolean available;
    @JsonSerialize final String phoneNumber;
    @JsonSerialize final VehicleResponse vehicle;
}
