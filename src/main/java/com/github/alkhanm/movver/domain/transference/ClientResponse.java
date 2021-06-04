package com.github.alkhanm.movver.domain.transference;

import com.github.alkhanm.movver.utils.DateUtil;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class ClientResponse {
    @Getter private final long id;
    @Getter private final String name, phoneNumber;
    private final LocalDateTime birthdate;

    public ClientResponse(long id, String name, String phoneNumber, LocalDateTime birthdate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
    }

    public Long getBirthdate() {
        return DateUtil.dateToMilliseconds(this.birthdate);
    }
}
