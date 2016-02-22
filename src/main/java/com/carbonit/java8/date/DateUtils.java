package com.carbonit.java8.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date parseDate(String date) {
        //TODO: Replace with LocalDate and DateTimeFormatter

        try {  //SimpleDateFormat not thread safe must create new formater for each request
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("bad format " + date);
        }
    }

    public static Date parseDateTime(String date) {
        //TODO: Replace with LocalDateTime and DateTimeFormatter
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return format.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("bad format " + date);
        }
    }

    public static int age(Date birthday, Date now) {
        //TODO: Replace with LocalDate and use Period
        Calendar calBirthday = Calendar.getInstance();
        calBirthday.setTime(birthday);

        Calendar calNow = Calendar.getInstance();
        calNow.setTime(now);

        int age = calNow.get(Calendar.YEAR) - calBirthday.get(Calendar.YEAR);
        if (calNow.get(Calendar.DAY_OF_YEAR) < calBirthday.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    public static Date addDuration(Date date, int minute) {
        //TODO: Replace By LocalDateTime
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);

        calendarDate.add(Calendar.MINUTE, minute);

        return calendarDate.getTime();
    }

}
