package com.witalis.praxis.leetcode.task.h9.p844.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 844
 * Name: Backspace String Compare
 * URL: <a href="https://leetcode.com/problems/backspace-string-compare/">Backspace String Compare</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string1;
    private String string2;

    public Boolean process() {
        return backspaceCompare(string1, string2);
    }

    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) return false;

        final int n1 = s.length();
        final int n2 = t.length();

        int d1 = 0;
        int d2 = 0;
        int i1 = n1 - 1;
        int i2 = n2 - 1;
        while (i1 >= 0 || i2 >= 0) {
            char c1 = '.';
            char c2 = '.';
            if (i1 >= 0) {
                c1 = s.charAt(i1);
                while (i1 >= 0 && (c1 == '#' || d1 > 0)) {
                    if (c1 == '#') {
                        d1++;
                    } else {
                        d1--;
                    }
                    i1--;
                    c1 = (i1 < 0) ? '.' : s.charAt(i1);
                }
            }
            if (i2 >= 0) {
                c2 = t.charAt(i2);
                while (i2 >= 0 && (c2 == '#' || d2 > 0)) {
                    if (c2 == '#') {
                        d2++;
                    } else {
                        d2--;
                    }
                    i2--;
                    c2 = (i2 < 0) ? '.' : t.charAt(i2);
                }
            }
            if (c1 != '.' && c2 != '.' && c1 != c2) return false;
            if (c1 == '.' && c2 != '.') return false;
            if (c2 == '.' && c1 != '.') return false;

            if (c1 != '.') i1--;
            if (c2 != '.') i2--;
        }

        return true;
    }
}
