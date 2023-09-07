package com.witalis.praxis.leetcode.task.h16.p1507.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static java.util.Map.entry;

/**
 * ID: 1507
 * Name: Reformat Date
 * URL: <a href="https://leetcode.com/problems/reformat-date/">Reformat Date</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String date;

    public String process() {
        return reformatDate(date);
    }

    public static final Map<String, String> MONTHS = Map.ofEntries(
        entry("Jan", "01"),
        entry("Feb", "02"),
        entry("Mar", "03"),
        entry("Apr", "04"),
        entry("May", "05"),
        entry("Jun", "06"),
        entry("Jul", "07"),
        entry("Aug", "08"),
        entry("Sep", "09"),
        entry("Oct", "10"),
        entry("Nov", "11"),
        entry("Dec", "12")
    );

    public String reformatDate(String date) {
        if (date == null || date.isEmpty()) return date;

        String[] parts = date.split("\\s+");

        if (parts.length != 3) return "";

        StringBuilder builder = new StringBuilder();
        builder.append(parts[2]);
        builder.append("-");
        builder.append(MONTHS.get(parts[1]));
        builder.append("-");
        builder.append(parts[0].length() == 3 ? ("0" + parts[0].charAt(0)) : parts[0].substring(0, 2));

        return builder.toString();
    }
}
