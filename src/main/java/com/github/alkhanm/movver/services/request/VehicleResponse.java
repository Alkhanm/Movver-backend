package com.github.alkhanm.movver.services.request;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponse {
    //O frontend recebe como uma string, não um enum
    private String model;
    private Integer capacity;
    private String licensePlate;
    private Boolean truckBodyWorkOpen;
    private String color;

    public void setModel(VehicleModelEnum model) {
        this.model = model.toString();
    }
}
