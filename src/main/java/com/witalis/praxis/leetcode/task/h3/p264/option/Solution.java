package com.witalis.praxis.leetcode.task.h3.p264.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 264
 * Name: Ugly Number II
 * URL: <a href="https://leetcode.com/problems/ugly-number-ii/">Ugly Number II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return nthUglyNumber(number);
    }

    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;
        int temp2 = 2, temp3 = 3, temp5 = 5, last;
        for (int i = 1; i < n; i++) {
            last = uglyNums[i - 1];

            if (last == temp2) temp2 = 2 * uglyNums[++index2];
            if (last == temp3) temp3 = 3 * uglyNums[++index3];
            if (last == temp5) temp5 = 5 * uglyNums[++index5];

            uglyNums[i] = Math.min(temp2, Math.min(temp3, temp5));
        }

        return uglyNums[n - 1];
    }
}
