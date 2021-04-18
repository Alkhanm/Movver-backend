package com.github.alkhanm.movver.services.request;

import com.github.alkhanm.movver.domain.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverResponse {
    long id;

    String location;
    boolean available;

    String name;
    String phoneNumber;

    Vehicle vehicle;
}
