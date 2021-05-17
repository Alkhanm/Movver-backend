package com.github.alkhanm.movver.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_client")
public class Client extends User {
    public Client() {}
    public Client(String name, String password, String phoneNumber, LocalDateTime birthDate) {
        super(name, password, phoneNumber, birthDate);
    }
}