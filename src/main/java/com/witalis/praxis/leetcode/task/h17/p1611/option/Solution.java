package com.witalis.praxis.leetcode.task.h17.p1611.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1611
 * Name: Minimum One Bit Operations to Make Integers Zero
 * URL: <a href="https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/">Minimum One Bit Operations to Make Integers Zero</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return minimumOneBitOperations(number);
    }

    public int minimumOneBitOperations(int n) {
        int ans = n;

        ans ^= ans >> 16;
        ans ^= ans >> 8;
        ans ^= ans >> 4;
        ans ^= ans >> 2;
        ans ^= ans >> 1;

        return ans;
    }
}
