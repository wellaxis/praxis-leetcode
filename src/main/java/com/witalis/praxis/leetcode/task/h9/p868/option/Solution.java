package com.witalis.praxis.leetcode.task.h9.p868.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 868
 * Name: Binary Gap
 * URL: <a href="https://leetcode.com/problems/binary-gap/">Binary Gap</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return binaryGap(number);
    }

    public int binaryGap(int n) {
        int res = 0;
        for (int d = -32; n > 0; n /= 2, d++)
            if (n % 2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
        return res;
    }
}
