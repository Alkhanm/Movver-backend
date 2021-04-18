package com.github.alkhanm.movver.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
