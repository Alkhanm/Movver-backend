package com.github.alkhanm.movver.services.mapper;

import com.github.alkhanm.movver.domain.entities.Vehicle;
import com.github.alkhanm.movver.services.request.VehicleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    VehicleResponse vehicleToResponse(Vehicle vehicle);
}
