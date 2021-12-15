package com.github.alkhanm.movver.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Table(name = "tb_client")
public class Client extends User {

    public Client() {

    }

    public Client(String name, String password, String phoneNumber, Long birthdate) {
        super(name, password, phoneNumber, birthdate);
    }
}