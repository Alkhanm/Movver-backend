package com.github.alkhanm.movver.domain.entities.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.alkhanm.movver.domain.entities.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DriverRequest {
    @JsonSerialize final String name;
    @JsonSerialize final String location;
    @JsonSerialize final boolean available;
    @JsonSerialize final String phoneNumber;
    @JsonSerialize final String password;
    @JsonSerialize final Vehicle vehicle;
}
