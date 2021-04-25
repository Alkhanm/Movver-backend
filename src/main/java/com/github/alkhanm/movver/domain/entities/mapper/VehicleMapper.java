package com.github.alkhanm.movver.domain.entities.mapper;

import com.github.alkhanm.movver.domain.entities.Vehicle;
import com.github.alkhanm.movver.domain.entities.transference.VehicleResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VehicleMapper extends Mapper<Vehicle, VehicleResponse, VehicleResponse> {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);
}
