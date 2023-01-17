package com.witalis.praxis.leetcode.task.h10.p926.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 926
 * Name: Flip String to Monotone Increasing
 * URL: <a href="https://leetcode.com/problems/flip-string-to-monotone-increasing/">Flip String to Monotone Increasing</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return minFlipsMonoIncr(string);
    }

    public int minFlipsMonoIncr(String s) {
        int zeroes = 0;
        int onesToZeroes = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroes++;
            } else {
                onesToZeroes++;
            }
            zeroes = Math.min(zeroes, onesToZeroes);
        }

        return zeroes;
    }
}
