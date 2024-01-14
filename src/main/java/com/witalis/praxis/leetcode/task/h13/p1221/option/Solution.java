package com.witalis.praxis.leetcode.task.h13.p1221.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1221
 * Name: Split a String in Balanced Strings
 * URL: <a href="https://leetcode.com/problems/split-a-string-in-balanced-strings/">Split a String in Balanced Strings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return balancedStringSplit(string);
    }

    public int balancedStringSplit(String s) {
        int count = 0;

        int cha = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                cha++;
            } else {
                cha--;
            }

            if (cha == 0) {
                count++;
            }

        }

        return count;
    }
}
