package com.witalis.praxis.leetcode.task.h2.p120.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ID: 120
 * Name: Triangle
 * URL: <a href="https://leetcode.com/problems/triangle/">Triangle</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<List<Integer>> triangle;

    public Integer process() {
        return minimumTotal(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];

        for (int i = 0; i < size; i++) {
            dp[i] = triangle.get(size - 1).get(i);
        }

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[j] = triangle.get(i - 1).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
