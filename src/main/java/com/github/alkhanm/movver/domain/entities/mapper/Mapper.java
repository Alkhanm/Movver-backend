package com.github.alkhanm.movver.domain.entities.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T, Response, Request> {
    Response toResponse(T t);
    T fromRequest(Request request);

    default List<Response> toResponseList(List<T> entityList){
        return entityList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
