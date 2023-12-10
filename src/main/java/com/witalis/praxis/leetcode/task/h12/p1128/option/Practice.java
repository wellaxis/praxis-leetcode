package com.witalis.praxis.leetcode.task.h12.p1128.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1128
 * Name: Number of Equivalent Domino Pairs
 * URL: <a href="https://leetcode.com/problems/number-of-equivalent-domino-pairs/">Number of Equivalent Domino Pairs</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] dominoes;

    public Integer process() {
        return numEquivDominoPairs(dominoes);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null) return 0;

        final int[][] counters = new int[9][9];
        for (int[] domino : dominoes)
            counters[domino[0] - 1][domino[1] - 1]++;

        int pairs = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                int count = counters[i][j];
                if (i != j) count += counters[j][i];
                pairs += calculateNumberOfPairs(count);
            }
        }

        return pairs;
    }

    private static int calculateNumberOfPairs(int count) {
        if (count == 0 || count == 1) return 0;

        return calculateNumberOfPairs(count -1) + (count - 1);
    }
}
