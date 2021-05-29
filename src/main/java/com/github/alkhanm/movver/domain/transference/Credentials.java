package com.github.alkhanm.movver.domain.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public record Credentials (
        @JsonSerialize String phoneNumber,
        @JsonSerialize String password
) {}
