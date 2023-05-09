package com.witalis.praxis.leetcode.task.h10.p925.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 925
 * Name: Long Pressed Name
 * URL: <a href="https://leetcode.com/problems/long-pressed-name/">Long Pressed Name</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String name;
    private String typed;

    public Boolean process() {
        return isLongPressedName(name, typed);
    }

    public boolean isLongPressedName(String name, String typed) {
        final int m = name.length();
        final int n = typed.length();

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (i < m && name.charAt(i) == typed.charAt(j))
                i++;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
        }

        return i == m;
    }
}
