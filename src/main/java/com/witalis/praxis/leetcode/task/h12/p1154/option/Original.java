package com.witalis.praxis.leetcode.task.h12.p1154.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * ID: 1154
 * Name: Day of the Year
 * URL: <a href="https://leetcode.com/problems/day-of-the-year/">Day of the Year</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String date;

    public Integer process() {
        return dayOfYear(date);
    }

    public int dayOfYear(String date) {
        if (date == null || date .isEmpty()) return -1;

        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            return -1;
        }

        return localDate.getDayOfYear();
    }
}
