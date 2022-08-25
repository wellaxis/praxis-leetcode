package com.witalis.praxis.leetcode.task.h6.p551.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 551
 * Name: Student Attendance Record I
 * URL: <a href="https://leetcode.com/problems/student-attendance-record-i/">Student Attendance Record I</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Boolean process() {
        return checkRecord(string);
    }

    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return false;

        if (s.length() - s.replace("A", "").length() >= 2) return false;
        return !s.contains("LLL");
    }
}
