package com.github.alkhanm.movver.domain.mapper;

import com.github.alkhanm.movver.domain.User;
import com.github.alkhanm.movver.domain.transference.UserResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper extends MvMapper<User, UserResponse> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
