package com.witalis.praxis.leetcode.task.h15.p1416.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1416
 * Name: Restore The Array
 * URL: <a href="https://leetcode.com/problems/restore-the-array/">Restore The Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private int number;

    public Integer process() {
        return numberOfArrays(string, number);
    }

    public int numberOfArrays(String s, int k) {
        final int MOD = 1_000_000_007;

        final int n = s.length();
        final int[] m = new int[n + 1];
        m[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                m[i] = 0;
                continue;
            }
            long res = 0;
            for (int j = i; j < n; j++) {
                res = res * 10 + (s.charAt(j) - '0');
                if (res > k) {
                    break;
                }
                m[i] = (m[i] + m[j + 1]) % MOD;
            }
        }

        return m[0];
    }
}
