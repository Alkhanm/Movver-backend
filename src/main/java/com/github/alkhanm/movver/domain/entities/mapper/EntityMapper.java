package com.github.alkhanm.movver.domain.entities.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface EntityMapper<Entity, Response, Request> {
    Response toResponse(Entity entity);
    Request toRequest(Entity entity);

    Entity fromRequest(Request request);
    Entity fromResponse(Response response);

    default List<Response> toResponseList(List<Entity> entityList){
        return entityList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
