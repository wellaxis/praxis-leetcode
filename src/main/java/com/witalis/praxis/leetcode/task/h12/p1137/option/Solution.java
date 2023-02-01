package com.witalis.praxis.leetcode.task.h12.p1137.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1137
 * Name: N-th Tribonacci Number
 * URL: <a href="https://leetcode.com/problems/n-th-tribonacci-number/">N-th Tribonacci Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return tribonacci(number);
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;

        for (int i = 3; i <= n; i++) {
            int temp = t2;
            t2 += t0 + t1;
            t0 = t1;
            t1 = temp;
        }

        return t2;
    }
}
