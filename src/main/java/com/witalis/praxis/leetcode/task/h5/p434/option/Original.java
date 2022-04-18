package com.witalis.praxis.leetcode.task.h5.p434.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 434
 * Name: Number of Segments in a String
 * URL: <a href="https://leetcode.com/problems/number-of-segments-in-a-string/">Number of Segments in a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return countSegments(string);
    }

    public int countSegments(String s) {
        if (s == null || s.trim().length() == 0) return 0;

        return s.trim().split("\\s+").length;
    }
}
