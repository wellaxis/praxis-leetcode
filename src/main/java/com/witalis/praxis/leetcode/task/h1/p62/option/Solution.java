package com.witalis.praxis.leetcode.task.h1.p62.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 62
 * Name: Unique Paths
 * URL: https://leetcode.com/problems/unique-paths/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int m;
    private int n;

    public Integer process() {
        return uniquePaths(m, n);
    }

    public int uniquePaths(int m, int n) {
        // how many steps we need to do
        int l = n + m - 2;
        // number of steps that need to go down
        int k = m - 1;
        double res = 1;

        // here we calculate the total possible path number
        // Combination(l, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++) {
            res = res * (l - k + i) / i;
        }

        return (int) res;
    }
}
