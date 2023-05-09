package com.witalis.praxis.leetcode.task.h10.p925.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 925
 * Name: Long Pressed Name
 * URL: <a href="https://leetcode.com/problems/long-pressed-name/">Long Pressed Name</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String name;
    private String typed;

    public Boolean process() {
        return isLongPressedName(name, typed);
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) return false;
        if (name.isEmpty() && typed.isEmpty()) return true;

        final char[] letters1 = name.toCharArray();
        final char[] letters2 = typed.toCharArray();

        final int n1 = letters1.length;
        final int n2 = letters2.length;

        if (n2 < n1) return false;
        if (letters1[0] != letters2[0]) return false;

        int i1 = 1;
        int i2 = 1;
        while (i1 < n1 && i2 < n2) {
            if (letters1[i1] == letters2[i2]) {
                i1++;
            } else {
                if (letters2[i2] != letters1[i1 - 1]) return false;
            }
            i2++;
        }
        if (i1 < n1) return false;
        while (i2 < n2 && letters2[i2] == letters1[n1 - 1]) i2++;

        return i2 == n2;
    }
}
