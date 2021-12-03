package com.witalis.praxis.leetcode.task.p50.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 50
 * Name: Pow(x, n)
 * URL: https://leetcode.com/problems/powx-n/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private double x;
    private int n;

    public Double process() {
        return myPow(x, n);
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (x == 1 || n == 1) return x;

        int sign = n < 0 ? -1 : 1;
        double result = pow(x, Math.abs((long) n));
        return sign == 1 ? result : 1 / result;
    }

    private double pow(double x, long n) {
        if (x == 1 || n == 1) return x;
        boolean odd = (n % 2 != 0);

        double tmp = pow(x, n / 2);
        double l = tmp * tmp;
        return l * ((odd) ? x : 1);
    }
}
