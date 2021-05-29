package com.github.alkhanm.movver.domain.mapper;

import com.github.alkhanm.movver.domain.Client;
import com.github.alkhanm.movver.domain.transference.ClientResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper extends MvMapper<Client, ClientResponse> {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
}