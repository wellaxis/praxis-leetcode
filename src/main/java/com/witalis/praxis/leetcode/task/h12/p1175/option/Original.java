package com.witalis.praxis.leetcode.task.h12.p1175.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1175
 * Name: Prime Arrangements
 * URL: <a href="https://leetcode.com/problems/prime-arrangements/">Prime Arrangements</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return numPrimeArrangements(number);
    }

    public static final int MOD = (int) 1e9 + 7;

    public int numPrimeArrangements(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n <= 3) return --n;

        int count = 0;
        int check = 0;
        for (int i = 2; i <= n; i++) {
            check = 0;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    check = 1;
                    break;
                }
            }
            if (check == 0) count++;
        }

        return (int) (modFactorial(count) % MOD * modFactorial(n - count) % MOD) % MOD;
    }

    private static long modFactorial(int n) {
        return (n <= 1) ? 1 : (n * modFactorial(n - 1) % MOD) % MOD;
    }
}
