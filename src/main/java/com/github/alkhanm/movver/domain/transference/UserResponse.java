package com.github.alkhanm.movver.domain.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.alkhanm.movver.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
public class UserResponse {
    @Getter final long id;
    @Getter final String name;
    @Getter final String phoneNumber;
    final LocalDateTime birthdate;

    public Long getBirthdate() {
        return DateUtil.dateToMilliseconds(birthdate);
    }
}
