package com.witalis.praxis.leetcode.task.h9.p844.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 844
 * Name: Backspace String Compare
 * URL: <a href="https://leetcode.com/problems/backspace-string-compare/">Backspace String Compare</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string1;
    private String string2;

    public Boolean process() {
        return backspaceCompare(string1, string2);
    }

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (true) {
            int backspace = 0;
            while (i >= 0 && (s.charAt(i) == '#' || backspace > 0)) {
                backspace += s.charAt(i) == '#' ? 1 : -1;
                --i;
            }
            backspace = 0;
            while (j >= 0 && (t.charAt(j) == '#' || backspace > 0)) {
                backspace += t.charAt(j) == '#' ? 1 : -1;
                --j;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                --i;
                --j;
            } else {
                break;
            }
        }

        return i == -1 && j == -1;
    }
}
