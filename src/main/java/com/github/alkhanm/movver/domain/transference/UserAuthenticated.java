package com.github.alkhanm.movver.domain.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserAuthenticated {
        private final UserResponse user;
        private final String token;
}
