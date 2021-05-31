package com.github.alkhanm.movver.domain.transference;

import com.github.alkhanm.movver.domain.Location;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
public class FreightResponse {
    @Getter final Long id;

    @Getter final String description;
    @Getter final int weight = 0;
    @Getter final double price, distance = 0.0;
    @Getter final Location origin, destination;
    @Getter final ClientResponse client;
    @Getter final DriverResponse driver;

     @Getter final LocalDateTime startDate, endDate;
     @Getter final FreightStatusEnum status;
     @Getter final FreightServiceEnum service;

}
