package com.github.alkhanm.movver.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String formatToBR(LocalDateTime date){
        return date.format(DateTimeFormatter.ofPattern("hh:mm dd/MM/yyyy"));
    }
    public static LocalDateTime millisecondsToDate(Long milliseconds){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.of("America/Sao_Paulo"));
    }

    public static Long dateToMilliseconds(LocalDateTime localDateTime){
        ZoneId zone = ZoneId.of("America/Sao_Paulo");
        return localDateTime.toInstant(zone.getRules().getOffset(localDateTime)).toEpochMilli();
    }
}
