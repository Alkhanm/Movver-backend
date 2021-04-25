package com.github.alkhanm.movver.domain.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public record Credentials (
        @JsonSerialize String phoneNumber,
        @JsonSerialize String password
) {}
