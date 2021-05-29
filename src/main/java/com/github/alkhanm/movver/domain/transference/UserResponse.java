package com.github.alkhanm.movver.domain.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@ToString
public class UserResponse {
    @Getter final long id;
    @Getter final String name;
    @Getter final String phoneNumber;
    @Getter final LocalDateTime birthdate;
}
