package com.witalis.praxis.leetcode.task.h6.p551.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 551
 * Name: Student Attendance Record I
 * URL: <a href="https://leetcode.com/problems/student-attendance-record-i/">Student Attendance Record I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Boolean process() {
        return checkRecord(string);
    }

    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absent++;
                late = 0;
                if (absent > 1) return false;
            } else if (s.charAt(i) == 'L') {
                late++;
                if (late == 3) return false;
            } else late = 0;
        }

        return true;
    }
}
