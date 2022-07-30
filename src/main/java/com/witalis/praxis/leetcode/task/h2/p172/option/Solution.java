package com.witalis.praxis.leetcode.task.h2.p172.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 172
 * Name: Factorial Trailing Zeroes
 * URL: <a href="https://leetcode.com/problems/factorial-trailing-zeroes/">Factorial Trailing Zeroes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return trailingZeroes(number);
    }

    public int trailingZeroes(int n) {
        int ans = 0;

        while (n > 0) {
            ans = ans + (n / 5);
            n = n / 5;
        }

        return ans;
    }
}
