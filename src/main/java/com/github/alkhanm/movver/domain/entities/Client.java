package com.github.alkhanm.movver.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id;
    @Getter private String name;
    @Getter private String phoneNumber;
    @Getter private String password;
    @Getter private LocalDateTime birthDate;
}
