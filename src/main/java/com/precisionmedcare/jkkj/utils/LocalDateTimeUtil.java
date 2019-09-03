package com.precisionmedcare.jkkj.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class LocalDateTimeUtil {
    public static void main(String[] args) {
        /*Date date = strConverseDate("ymdhms");
        System.out.println(date);*/
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate1 = LocalDate.now(ZoneId.systemDefault());
        System.out.println(localDate1);
        LocalTime localTime = LocalTime.now(ZoneId.systemDefault());
        System.out.println(localTime);
        LocalTime localTime1 = LocalTime.now(ZoneId.systemDefault());
        System.out.println(localTime1);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1, localTime1);
        System.out.println(localDateTime1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId zone = dateTimeFormatter.getZone();
        System.out.println(zone);

    }
}
