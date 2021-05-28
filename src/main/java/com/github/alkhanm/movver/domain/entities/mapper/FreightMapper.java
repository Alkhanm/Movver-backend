package com.github.alkhanm.movver.domain.entities.mapper;

import com.github.alkhanm.movver.domain.entities.Freight;
import com.github.alkhanm.movver.domain.entities.FreightResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FreightMapper extends Mapper<Freight, FreightResponse> {
    FreightMapper INSTANCE = Mappers.getMapper(FreightMapper.class);
}
