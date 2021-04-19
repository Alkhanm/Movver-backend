package com.github.alkhanm.movver.services.mapper;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.services.request.DriverRequest;
import com.github.alkhanm.movver.services.request.DriverResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

    DriverResponse driverToResponse(Driver driver);
    List<DriverResponse> driverResponseList(List<Driver> drivers);

    DriverRequest driverToRequest(Driver driver);

    Driver responseToDriver(DriverResponse driver);
    Driver requestToDriver(DriverRequest driver);
}