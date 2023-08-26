package com.witalis.praxis.leetcode.task.h7.p646.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 646
 * Name: Maximum Length of Pair Chain
 * URL: <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">Maximum Length of Pair Chain</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] pairs;

    public Integer process() {
        return findLongestChain(pairs);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int res = 1;
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                res++;
                end = pairs[i][1];
            }
        }

        return res;
    }
}
