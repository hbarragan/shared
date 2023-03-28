package com.formacion.core.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter FORMATTER_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final String LIKE_ANY_OPERATOR = "%";

    public Utils() {
    }

    public static LocalDateTime stringToDate(String date) {
        return date != null ? LocalDateTime.parse(date, FORMATTER_DATE_FORMAT) : null;
    }

    public static String dateToString(LocalDateTime date) {
        return date != null ? date.format(FORMATTER_DATE_FORMAT) : null;
    }

    public static boolean validateSameDateByYearMonthDay(LocalDateTime date, LocalDateTime date2) {
        return date != null && date2 != null && date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDayOfMonth() == date2.getDayOfMonth();
    }

    public static LocalTime localDateTimeToLocalTime(LocalDateTime data) {
        return LocalTime.of(data.getHour(), data.getMinute());
    }

    public static String convertMapToString(Map<?, ?> map) {
        return (String)map.keySet().stream().map((key) -> {
            return "" + key + ": " + map.get(key);
        }).collect(Collectors.joining(","));
    }
}
