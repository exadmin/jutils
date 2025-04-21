package com.github.exadmin.jutils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);

    /**
     * Returns current time (at the moment of call) in the format which is specified in the DEFAULT_FORMATTER constant.
     * @return String value
     */
    public static String getCurrentDateTimeStamp() {
        return LocalDateTime.now().format(DEFAULT_FORMATTER);
    }
}
