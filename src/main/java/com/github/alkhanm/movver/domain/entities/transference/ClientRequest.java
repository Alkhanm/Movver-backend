package com.github.alkhanm.movver.domain.entities.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ClientRequest {
    @JsonSerialize final String name;
    @JsonSerialize final String phoneNumber;
    @JsonSerialize final LocalDateTime birthDate;
}
