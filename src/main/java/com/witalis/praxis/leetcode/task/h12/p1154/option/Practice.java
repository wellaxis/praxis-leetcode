package com.witalis.praxis.leetcode.task.h12.p1154.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * ID: 1154
 * Name: Day of the Year
 * URL: <a href="https://leetcode.com/problems/day-of-the-year/">Day of the Year</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String date;

    public Integer process() {
        return dayOfYear(date);
    }

    public int dayOfYear(String date) {
        if (date == null || date .isEmpty()) return -1;

        final String PATTERN = "\\d{4}-\\d{2}-\\d{2}";

        if (date.matches(PATTERN))
            return LocalDate.parse(date, DateTimeFormatter.ISO_DATE).getDayOfYear();

        return -1;
    }
}
