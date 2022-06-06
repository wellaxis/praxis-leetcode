package com.witalis.praxis.leetcode.task.h4.p338.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 338
 * Name: Counting Bits
 * URL: <a href="https://leetcode.com/problems/counting-bits/">Counting Bits</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public int[] process() {
        return countBits(number);
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = (i % 2) + ans[i / 2];
        }

        return ans;
    }
}
