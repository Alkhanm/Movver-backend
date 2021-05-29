package com.github.alkhanm.movver.domain.mapper;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.transference.FreightResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FreightMapper extends MvMapper<Freight, FreightResponse> {
    FreightMapper INSTANCE = Mappers.getMapper(FreightMapper.class);
}
