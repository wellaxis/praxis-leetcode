package com.witalis.praxis.leetcode.task.h16.p1569.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ID: 1569
 * Name: Number of Ways to Reorder Array to Get Same BST
 * URL: <a href="https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/">Number of Ways to Reorder Array to Get Same BST</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Practice(int[] numbers) {
        this.numbers = numbers;
    }

    public Integer process() {
        return numOfWays(numbers);
    }

    public static final int MOD = (int) (1e9 + 7);
    private long[][] dp;

    public int numOfWays(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;
        this.dp = new long[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i - 1] = i;
            dp[i][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                if (i >= j) {
                    dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j] % MOD) % MOD;
                } else {
                    break;
                }
            }
        }

        return (int) recursiveWays(Arrays.stream(nums).boxed().map(Long::valueOf).toList()) - 1;
    }

    private long recursiveWays(List<Long> nums) {
        final int n = nums.size();

        if (n <= 1) return 1;

        final List<Long> left = new LinkedList<>();
        final List<Long> right = new LinkedList<>();
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(0)) {
                right.add(nums.get(i));
            } else {
                left.add(nums.get(i));
            }
        }
        final int ln = left.size();
        final int rn = right.size();

        return recursiveWays(left) * recursiveWays(right) % MOD * dp[ln + rn][ln] % MOD;
    }
}
