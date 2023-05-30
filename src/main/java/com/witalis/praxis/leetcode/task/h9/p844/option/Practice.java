package com.witalis.praxis.leetcode.task.h9.p844.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 844
 * Name: Backspace String Compare
 * URL: <a href="https://leetcode.com/problems/backspace-string-compare/">Backspace String Compare</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string1;
    private String string2;

    public Boolean process() {
        return backspaceCompare(string1, string2);
    }

    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) return false;

        int i1 = s.length() - 1;
        int i2 = t.length() - 1;
        while (i1 >= 0 || i2 >= 0) {
            char c1 = '.';
            if (i1 >= 0) {
                c1 = s.charAt(i1);
                int d1 = 0;
                while (i1 >= 0 && (c1 == '#' || d1 > 0)) {
                    i1--;
                    d1 = (c1 == '#') ? d1 + 1 : d1 - 1;
                    c1 = (i1 < 0) ? '.' : s.charAt(i1);
                }
            }
            char c2 = '.';
            if (i2 >= 0) {
                c2 = t.charAt(i2);
                int d2 = 0;
                while (i2 >= 0 && (c2 == '#' || d2 > 0)) {
                    i2--;
                    d2 = (c2 == '#') ? d2 + 1 : d2 - 1;
                    c2 = (i2 < 0) ? '.' : t.charAt(i2);
                }
            }
            if (i1 >= 0 && i2 >= 0 && c1 != c2) return false;
            if (i1 < 0 && i2 >= 0) return false;
            if (i1 >= 0 && i2 < 0) return false;

            i1--;
            i2--;
        }

        return true;
    }
}
