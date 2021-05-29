package com.github.alkhanm.movver.domain.transference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@ToString
public class ClientResponse {
    @Getter final long id;
    @Getter final String name, phoneNumber;
    @Getter final LocalDateTime birthdate;
}
