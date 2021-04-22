package com.github.alkhanm.movver.domain.entities.mapper;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.transference.ClientRequest;
import com.github.alkhanm.movver.domain.entities.transference.ClientResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper extends EntityMapper<Client, ClientResponse, ClientRequest> {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
}