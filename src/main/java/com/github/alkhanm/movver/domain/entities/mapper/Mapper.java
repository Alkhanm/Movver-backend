package com.github.alkhanm.movver.domain.entities.mapper;
import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<Entity, Response> {
    Response toResponse(Entity r);

    default List<Response> toResponseList(List<Entity> entityList){
        return entityList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
