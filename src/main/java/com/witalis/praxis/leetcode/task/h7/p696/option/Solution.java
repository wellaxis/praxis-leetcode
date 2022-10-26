package com.witalis.praxis.leetcode.task.h7.p696.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 696
 * Name: Count Binary Substrings
 * URL: <a href="https://leetcode.com/problems/count-binary-substrings/">Count Binary Substrings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return countBinarySubstrings(string);
    }

    public int countBinarySubstrings(String s) {
        int sum = 0;

        int prev = 0;
        int cur = 1;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                cur++;
            } else {
                sum += Math.min(cur, prev);
                prev = cur;
                cur = 1;
            }
        }
        sum += Math.min(cur, prev);

        return sum;
    }
}
