package com.github.alkhanm.movver.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
