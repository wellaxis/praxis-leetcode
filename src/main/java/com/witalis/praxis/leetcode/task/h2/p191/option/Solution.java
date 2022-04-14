package com.witalis.praxis.leetcode.task.h2.p191.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 191
 * Name: Number of 1 Bits
 * URL: <a href="https://leetcode.com/problems/number-of-1-bits/">Number of 1 Bits</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return hammingWeight(number);
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (; n != 0; n = n & (n - 1))
            count++;
        return count;
    }
}
