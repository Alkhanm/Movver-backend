package com.github.alkhanm.movver.domain.entities;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_location")
@Getter @ToString
public class Location {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;

    public Location() {}

    public Location(Long id, String name, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
