package com.github.alkhanm.movver.services.mapper;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.services.request.DriverRequest;
import com.github.alkhanm.movver.services.request.DriverResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

    DriverResponse toResponse(Driver driver);
    DriverRequest toRequest(Driver driver);

    Driver fromResponse(DriverResponse driver);
    Driver fromRequest(DriverRequest driver);
}