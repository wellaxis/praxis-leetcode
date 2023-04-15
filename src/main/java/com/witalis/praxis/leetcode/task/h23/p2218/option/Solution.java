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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<List<Integer>> piles;
    private int coins;

    public Integer process() {
        return maxValueOfCoins(piles, coins);
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] mv = new int[k + 1];
        int[] pileSum = new int[k + 1];
        for (List<Integer> pile : piles) {
            int n = Math.min(k, pile.size());
            int sum = 0;
            for (int i = 1; i <= n; i++)
                pileSum[i] = sum += pile.get(i - 1);
            for (int i = k; i > 0; i--) {
                int max = 0;
                for (int j = Math.min(i, n); j >= 0; j--)
                    max = Math.max(max, pileSum[j] + mv[i - j]);
                mv[i] = max;
            }
        }

        return mv[k];
    }
}
