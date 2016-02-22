package com.carbonit.java8.date;

import com.carbonit.java8.TemporalAccessorAssert;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static com.carbonit.java8.date.DateUtils.parseDate;
import static com.carbonit.java8.TemporalAccessorAssert.assertThat;
import static com.carbonit.java8.date.DateUtils.parseDateTime;

public class DateUtilsTest {


    @Test
    public void should_parse_date() {
        assertThat(parseDate("27/01/2014")).isInSameDayAs("2014-01-27");

    }

    @Test
    public void should_parse_date_time() {
        assertThat(parseDateTime("27/01/2014 12:05:10")).
                isInSameDayAs("2014-01-27").
                isWithinHourOfDay(12).
                isWithinHourOfDay(12).
                isWithinSecond(10);
    }

    @Test
    public void should_compute_age() {
        Assertions.assertThat(computeAgeFor("2013-07-08", "2014-02-06")).isEqualTo(0);
        Assertions.assertThat(computeAgeFor("2010-10-12", "2014-02-06")).isEqualTo(3);
        Assertions.assertThat(computeAgeFor("2010-01-28", "2014-02-06")).isEqualTo(4);
    }

    private int computeAgeFor(String birthday, String currentDate) {
        //TODO:Change parseDateJava7 to parseDateJava8 for switch to localDate

        return DateUtils.age(parseDateJava8(birthday), parseDateJava8(currentDate));
    }

    @Test
    public void should_add_duration() {
        //TODO:Change parseDateTimeJava7 to parseDateTimeJava8 for switch to localDate
        assertThat(DateUtils.addDuration(parseDateTimeJava8("2014-01-27T12:05:10"), 162))
                .isInSameDayAs("2014-01-27")
                .isWithinHourOfDay(14)
                .isWithinMinute(47)
                .isWithinSecond(10);
    }

    private Date parseDateTimeJava7(String dateTime) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateTime);
        } catch (ParseException e) {
            return null;
        }
    }

    private LocalDateTime parseDateTimeJava8(String dateTime) {
        return LocalDateTime.parse(dateTime);
    }


    private Date parseDateJava7(String java7Date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(java7Date);
        } catch (ParseException e) {
            return null;
        }
    }

    private LocalDate parseDateJava8(String date) {
        return LocalDate.parse(date);
    }

}