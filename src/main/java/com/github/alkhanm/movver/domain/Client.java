package com.github.alkhanm.movver.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_client")
public class Client extends User {
    public Client() {}
    public Client(Long id, String name, String password, String phoneNumber, Long birthDate) {
        super(name, password, phoneNumber, birthDate);
        this.id = id;
    }
}