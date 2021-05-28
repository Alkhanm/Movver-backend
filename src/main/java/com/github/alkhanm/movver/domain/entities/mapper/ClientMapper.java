package com.github.alkhanm.movver.domain.entities.mapper;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.User;
import com.github.alkhanm.movver.domain.entities.transference.ClientResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper extends Mapper<Client, ClientResponse> {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
}