package com.witalis.praxis.leetcode.task.h26.p2551.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2551
 * Name: Put Marbles in Bags
 * URL: <a href="https://leetcode.com/problems/put-marbles-in-bags/">Put Marbles in Bags</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] weights;
    private int bags;

    public Long process() {
        return putMarbles(weights, bags);
    }

    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairWeights, 0, n - 1);

        long answer = 0L;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
}
