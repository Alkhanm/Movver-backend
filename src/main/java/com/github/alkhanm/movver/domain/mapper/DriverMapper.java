package com.github.alkhanm.movver.domain.mapper;

import com.github.alkhanm.movver.domain.Driver;
import com.github.alkhanm.movver.domain.transference.DriverResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DriverMapper extends MvMapper<Driver, DriverResponse> {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);
}