package com.github.alkhanm.movver.domain.entities.transference;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ClientResponse {
    @Getter final long id;
    @Getter final String name;
    @Getter final String phoneNumber;
    @Getter final LocalDateTime birthDate;
}
