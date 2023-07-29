package com.witalis.praxis.leetcode.task.h9.p808.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 808
 * Name: Soup Servings
 * URL: <a href="https://leetcode.com/problems/soup-servings/">Soup Servings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Original(int number) {
        this.number = number;
    }

    public Double process() {
        return soupServings(number);
    }

    enum Operation {
        SERVE1(100, 0),
        SERVE2(75, 25),
        SERVE3(50, 50),
        SERVE4(25, 75);

        private final int soup1;
        private final int soup2;

        Operation(int soup1, int soup2) {
            this.soup1 = soup1;
            this.soup2 = soup2;
        }
    }

    private double[][] memo;

    public double soupServings(int n) {
        if (n < 0) return 0D;
        if (n > 10_000) return 1D;

        this.memo = new double[n + 1][n + 1];
        for (double[] arr : memo) Arrays.fill(arr, -1D);

        return solver(n, n);
    }

    private double solver(int soup1, int soup2) {
        if (soup1 <= 0 || soup2 <= 0) {
            if (soup1 <= 0 && soup2 <= 0) return 0.5;
            return (soup1 <= 0) ? 1 : 0;
        }

        if (memo[soup1][soup2] != -1) return memo[soup1][soup2];

        double probability = 0D;
        for (Operation operation : Operation.values()) {
            probability += solver(soup1 - operation.soup1, soup2 - operation.soup2) / 4;
        }

        memo[soup1][soup2] = probability;

        return probability;
    }
}
