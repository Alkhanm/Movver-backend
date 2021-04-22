package com.github.alkhanm.movver.domain.entities.mapper;

import com.github.alkhanm.movver.domain.entities.Vehicle;
import com.github.alkhanm.movver.domain.entities.transference.VehicleResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VehicleMapper extends EntityMapper<Vehicle, VehicleResponse, VehicleResponse> {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);
}
