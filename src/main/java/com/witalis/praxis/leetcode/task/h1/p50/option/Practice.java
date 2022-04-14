package com.witalis.praxis.leetcode.task.h1.p50.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 50
 * Name: Pow(x, n)
 * URL: <a href="https://leetcode.com/problems/powx-n/">Pow(x, n)</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private double x;
    private int n;

    public Double process() {
        return myPow(x, n);
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (x == 1 || n == 1) return x;

        return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;

        double inner = pow(x, n / 2);
        double affix = n > 0 ? x : 1 / x;

        return (n % 2 == 0 ? 1 : affix) * inner * inner;
    }
}
