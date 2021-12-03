package com.witalis.praxis.leetcode.task.p50.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 50
 * Name: Pow(x, n)
 * URL: https://leetcode.com/problems/powx-n/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private double x;
    private int n;

    public Double process() {
        return myPow(x, n);
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double temp = myPow(x, n / 2);

        if (n % 2 == 0)
            return temp * temp;
        else {
            if (n > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
}
