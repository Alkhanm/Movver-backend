package com.github.alkhanm.movver.domain.entities.mapper;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.domain.entities.transference.DriverRequest;
import com.github.alkhanm.movver.domain.entities.transference.DriverResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DriverMapper extends EntityMapper<Driver, DriverResponse, DriverRequest> {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);
}