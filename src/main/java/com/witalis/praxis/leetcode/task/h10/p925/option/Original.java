package com.witalis.praxis.leetcode.task.h10.p925.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 925
 * Name: Long Pressed Name
 * URL: <a href="https://leetcode.com/problems/long-pressed-name/">Long Pressed Name</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String name;
    private String typed;

    public Boolean process() {
        return isLongPressedName(name, typed);
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) return false;
        if (name.isEmpty() && typed.isEmpty()) return true;

        final int n1 = name.length();
        final int n2 = typed.length();

        if (n2 < n1) return false;

        final char[] letters1 = name.toCharArray();
        final char[] letters2 = typed.toCharArray();

        if (letters1[0] != letters2[0]) return false;

        int i1 = 1;
        int i2 = 1;
        while (i1 < n1 && i2 < n2) {
            final char letter1 = letters1[i1];
            final char letter2 = letters2[i2];

            if (letter1 == letter2) {
                i1++;
                i2++;
            } else {
                if (letter2 == letters1[i1 - 1]) {
                    i2++;
                } else {
                    return false;
                }
            }
        }
        if (i1 < n1) return false;
        if (i2 < n2) {
            while (i2 < n2) {
                final char letter2 = letters2[i2];

                if (letter2 != letters1[n1 - 1]) return false;
                i2++;
            }
        }

        return true;
    }
}
