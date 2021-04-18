package com.github.alkhanm.movver.services.request;

import com.github.alkhanm.movver.domain.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverRequest {
    private String name;

    private String location;
    private boolean available;

    private String phoneNumber;
    private String password;

    private Vehicle vehicle;
}
