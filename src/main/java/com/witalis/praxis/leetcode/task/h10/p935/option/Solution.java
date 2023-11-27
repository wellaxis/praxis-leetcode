package com.witalis.praxis.leetcode.task.h10.p935.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 935
 * Name: Knight Dialer
 * URL: <a href="https://leetcode.com/problems/knight-dialer/">Knight Dialer</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return knightDialer(number);
    }

    public int knightDialer(int n) {
        if (n == 1) return 10;

        final int MOD = (int) 1e9 + 7;

        int a = 4;
        int b = 2;
        int c = 2;
        int d = 1;

        for (int i = 0; i < n - 1; i++) {
            int aTemp = a;
            int bTemp = b;
            int cTemp = c;
            int dTemp = d;

            a = ((2 * bTemp) % MOD + (2 * cTemp) % MOD) % MOD;
            b = aTemp;
            c = (aTemp + (2 * dTemp) % MOD) % MOD;
            d = cTemp;
        }

        return (((a + b) % MOD + c) % MOD + d) % MOD;
    }
}
