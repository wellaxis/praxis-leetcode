package com.witalis.praxis.leetcode.task.h6.p551.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 551
 * Name: Student Attendance Record I
 * URL: <a href="https://leetcode.com/problems/student-attendance-record-i/">Student Attendance Record I</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Boolean process() {
        return checkRecord(string);
    }

    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return false;

        int absence = 0;
        int lateness = 0;
        for (char attendance : s.toCharArray()) {
            switch (attendance) {
                case 'A' -> {
                    absence++;
                    if (absence == 2) return false;
                    lateness = 0;
                }
                case 'L' -> {
                    lateness++;
                    if (lateness == 3) return false;
                }
                default -> lateness = 0;
            }
        }

        return true;
    }
}
