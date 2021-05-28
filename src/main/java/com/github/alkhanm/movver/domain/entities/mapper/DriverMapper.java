package com.github.alkhanm.movver.domain.entities.mapper;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.domain.entities.User;
import com.github.alkhanm.movver.domain.entities.transference.DriverResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DriverMapper extends Mapper<Driver, DriverResponse> {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);
}