package com.github.alkhanm.movver.domain.mapper;
import java.util.List;
import java.util.stream.Collectors;

public interface MvMapper<Entity, Response> {
    Response toResponse(Entity entity);

    default List<Response> toResponseList(List<Entity> entityList){
        return entityList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
