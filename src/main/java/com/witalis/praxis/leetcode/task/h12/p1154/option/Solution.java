package com.witalis.praxis.leetcode.task.h12.p1154.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1154
 * Name: Day of the Year
 * URL: <a href="https://leetcode.com/problems/day-of-the-year/">Day of the Year</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String date;

    public Integer process() {
        return dayOfYear(date);
    }

    public int dayOfYear(String date) {
        int month = 10 * date.charAt(5) + date.charAt(6) - 528;
        int day = 10 * date.charAt(8) + date.charAt(9) - 528;

        // fast return if we don't need leap years
        if (month <= 2) return day + (1 - month >>> 27);

        // months between
        day += 30 * month + month / 2 - 32 + ((month - 1 >> 3) & month);

        // leap year
        int yearPart = 10 * date.charAt(2) + date.charAt(3) - 528;
        if (yearPart == 0) yearPart = 10 * date.charAt(0) + date.charAt(1) - 528;

        return day + (((yearPart & 3) - 1) >>> 31);
    }
}
