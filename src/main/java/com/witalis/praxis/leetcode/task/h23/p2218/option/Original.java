package com.witalis.praxis.leetcode.task.h23.p2218.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ID: 2218
 * Name: Maximum Value of K Coins From Piles
 * URL: <a href="https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/">Maximum Value of K Coins From Piles</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<List<Integer>> piles;
    private int coins;

    public Integer process() {
        return maxValueOfCoins(piles, coins);
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        if (piles == null || k <= 0) return 0;

        int[] dp = new int[k + 1];
        for (List<Integer> pile : piles) {
            int size = pile.size();
            int[] sums = new int[size + 1];
            for (int i = 0; i < size; i++)
                sums[i + 1] = sums[i] + pile.get(i);

            int[] dpi = new int[k + 1];
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j <= size && i + j <= k; j++) {
                    dpi[i + j] = Math.max(dpi[i + j], dp[i] + sums[j]);
                }
            }
            dp = dpi;
        }

        return dp[k];
    }
}
