package com.witalis.praxis.leetcode.task.h16.p1507.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1507
 * Name: Reformat Date
 * URL: <a href="https://leetcode.com/problems/reformat-date/">Reformat Date</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String date;

    public String process() {
        return reformatDate(date);
    }

    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        StringBuilder sb = new StringBuilder();
        if (date.length() == 13) {
            return sb.append(date.substring(9))
                .append("-")
                .append(months.get(date.substring(5, 8)))
                .append("-").append(date.substring(0, 2))
                .toString();
        }
        return sb.append(date.substring(8))
            .append("-")
            .append(months.get(date.substring(4, 7)))
            .append("-0")
            .append(date.substring(0, 1))
            .toString();
    }
}
