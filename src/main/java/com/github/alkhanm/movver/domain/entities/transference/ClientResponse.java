package com.github.alkhanm.movver.domain.entities.transference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @ToString
public class ClientResponse {
    final long id;
    final String name;
    final String phoneNumber;
    final LocalDateTime birthDate;
}
