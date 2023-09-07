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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String date;

    public String process() {
        return reformatDate(date);
    }

    public static final Map<String, String> DAYS = Map.ofEntries(
        entry("1st", "01"),
        entry("2nd", "02"),
        entry("3rd", "03"),
        entry("4th", "04"),
        entry("5th", "05"),
        entry("6th", "06"),
        entry("7th", "07"),
        entry("8th", "08"),
        entry("9th", "09"),
        entry("10th", "10"),
        entry("11th", "11"),
        entry("12th", "12"),
        entry("13th", "13"),
        entry("14th", "14"),
        entry("15th", "15"),
        entry("16th", "16"),
        entry("17th", "17"),
        entry("18th", "18"),
        entry("19th", "19"),
        entry("20th", "20"),
        entry("21st", "21"),
        entry("22nd", "22"),
        entry("23rd", "23"),
        entry("24th", "24"),
        entry("25th", "25"),
        entry("26th", "26"),
        entry("27th", "27"),
        entry("28th", "28"),
        entry("29th", "29"),
        entry("30th", "30"),
        entry("31st", "31")
    );

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

        String[] parts = date.split(" ");

        if (parts.length != 3) return "";

        return parts[2] + "-" + MONTHS.get(parts[1]) + "-" + DAYS.get(parts[0]);
    }
}
