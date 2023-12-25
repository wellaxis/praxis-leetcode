package com.witalis.praxis.leetcode.task.h12.p1185.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1185
 * Name: Day of the Week
 * URL: <a href="https://leetcode.com/problems/day-of-the-week/">Day of the Week</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int day;
    private int month;
    private int year;

    public String process() {
        return dayOfTheWeek(day, month, year);
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] days = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;

        for (int i = 1971; i < year; ++i)
            count += i % 4 == 0 ? 366 : 365;
        for (int i = 0; i < month - 1; ++i)
            count += days[i];
        count += day;

        return week[(count + 4) % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
