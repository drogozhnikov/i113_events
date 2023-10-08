package com.micro.i113_events.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DateCalculator {

    public String countDaysBetweenToday(Date date) {
        DateTime today = new DateTime();
        DateTime inputDate = new DateTime(date.getTime());
        DateTime birthday = new DateTime(
                today.getYear(),
                inputDate.getMonthOfYear(),
                inputDate.getDayOfMonth(),
                0, 0);
        if (birthday.isBefore(today)) {
            birthday = new DateTime(
                    today.getYear() + 1,
                    birthday.getMonthOfYear(),
                    birthday.getDayOfMonth(),
                    0,
                    0
            );
        }
        int test = Days.daysBetween(
                new LocalDate(today),
                new LocalDate(birthday)).getDays();

        if (test == 366) {
            return "0";
        }
        return String.valueOf(test);
    }

}
