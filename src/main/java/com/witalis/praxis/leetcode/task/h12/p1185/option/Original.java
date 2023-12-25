package com.witalis.praxis.leetcode.task.h12.p1185.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * ID: 1185
 * Name: Day of the Week
 * URL: <a href="https://leetcode.com/problems/day-of-the-week/">Day of the Week</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int day;
    private int month;
    private int year;

    public String process() {
        return dayOfTheWeek(day, month, year);
    }

    public static final String[] WEEK = new String[] {
        "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    public String dayOfTheWeek(int day, int month, int year) {
        if (day <= 0 || month <= 0 || year <= 0) return "";

        LocalDate localDate;
        try {
            localDate = LocalDate.of(year, month, day);
        } catch (DateTimeParseException e) {
            return "";
        }

        return WEEK[localDate.getDayOfWeek().getValue()];
    }
}
