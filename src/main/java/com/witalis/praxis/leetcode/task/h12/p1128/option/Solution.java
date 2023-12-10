package com.witalis.praxis.leetcode.task.h12.p1128.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1128
 * Name: Number of Equivalent Domino Pairs
 * URL: <a href="https://leetcode.com/problems/number-of-equivalent-domino-pairs/">Number of Equivalent Domino Pairs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] dominoes;

    public Integer process() {
        return numEquivDominoPairs(dominoes);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];
        int count = 0;

        for (int[] pair : dominoes) {
            int key;
            if (pair[0] <= pair[1]) {
                key = pair[0] * 10 + pair[1];
            } else {
                key = pair[1] * 10 + pair[0];
            }

            count += map[key]++;
        }

        return count;
    }
}
