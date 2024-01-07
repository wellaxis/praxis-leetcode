package com.witalis.praxis.leetcode.task.h5.p446.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ID: 446
 * Name: Arithmetic Slices II - Subsequence
 * URL: <a href="https://leetcode.com/problems/arithmetic-slices-ii-subsequence/">Arithmetic Slices II - Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return numberOfArithmeticSlices(numbers);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        final int n = nums.length;

        int[][] dp = new int[n][n];
        HashMap<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long temp = nums[i];
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(i);
        }

        int sum = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long a = 2L * nums[i] - nums[j];
                if (map.containsKey(a)) {
                    for (int k : map.get(a)) {
                        if (k < i) {
                            dp[i][j] += dp[k][i] + 1;
                        } else {
                            break;
                        }
                    }
                }
                sum += dp[i][j];
            }
        }

        return sum;
    }
}
