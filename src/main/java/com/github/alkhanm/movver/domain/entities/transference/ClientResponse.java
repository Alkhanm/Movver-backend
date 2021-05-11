package com.github.alkhanm.movver.domain.entities.transference;

import lombok.Getter;

import java.time.LocalDateTime;

public class ClientResponse {
    @Getter final long id;
    @Getter final String name;
    @Getter final String phoneNumber;
    @Getter final LocalDateTime birthDate;

    public ClientResponse(long id, String name, String phoneNumber, LocalDateTime birthDate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }
}
