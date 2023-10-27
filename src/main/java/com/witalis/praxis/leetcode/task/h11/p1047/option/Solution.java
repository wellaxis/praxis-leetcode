package com.witalis.praxis.leetcode.task.h11.p1047.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1047
 * Name: Remove All Adjacent Duplicates In String
 * URL: <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">Remove All Adjacent Duplicates In String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return removeDuplicates(string);
    }

    public String removeDuplicates(String s) {
        if (s == null) return s;

        int end = -1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (end >= 0 && chars[end] == c) {
                --end;
            } else {
                chars[++end] = c;
            }
        }

        return String.valueOf(chars, 0, end + 1);
    }
}
