package com.github.alkhanm.movver.domain.transference;

import com.github.alkhanm.movver.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
public class ClientResponse {
    @Getter final long id;
    @Getter final String name, phoneNumber;
    final LocalDateTime birthdate;

    public Long getBirthdate() {
        return DateUtil.dateToMilliseconds(this.birthdate);
    }
}
