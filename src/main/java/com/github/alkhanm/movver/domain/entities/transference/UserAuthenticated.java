package com.github.alkhanm.movver.domain.entities.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.alkhanm.movver.domain.entities.User;

public record UserAuthenticated (
        @JsonSerialize User user,
        @JsonSerialize String token
) {}
