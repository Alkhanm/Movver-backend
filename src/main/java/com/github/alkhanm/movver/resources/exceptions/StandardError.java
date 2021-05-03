package com.github.alkhanm.movver.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

public record StandardError(
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
  @JsonSerialize Instant instant,
  @JsonSerialize int status,
  @JsonSerialize String error,
  @JsonSerialize String message,
  @JsonSerialize String path
) {}
