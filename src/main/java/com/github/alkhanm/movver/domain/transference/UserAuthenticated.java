package com.github.alkhanm.movver.domain.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public record UserAuthenticated (
        @JsonSerialize UserResponse user,
        @JsonSerialize String token
) {}
