package com.witalis.praxis.leetcode.task.h5.p434.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 434
 * Name: Number of Segments in a String
 * URL: <a href="https://leetcode.com/problems/number-of-segments-in-a-string/">Number of Segments in a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return countSegments(string);
    }

    public int countSegments(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.trim().length() == 0) return 0;

        int counter = 0;
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != ' ') i++;
            while (i < s.length() && s.charAt(i) == ' ') i++;
            counter++;
        }

        return counter;
    }
}
