package com.witalis.praxis.leetcode.task.h16.p1569.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 1569
 * Name: Number of Ways to Reorder Array to Get Same BST
 * URL: <a href="https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/">Number of Ways to Reorder Array to Get Same BST</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return numOfWays(numbers);
    }

    public static final int MOD = 1_000_000_007;

    public int numOfWays(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;
        long[][] dp = new long[n + 1][n + 1];
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

        List<Long> list = Arrays.stream(nums).boxed().map(Long::valueOf).toList();

        return (int) recursiveWays(list, dp) - 1;
    }

    private long recursiveWays(List<Long> nums, long[][] dp) {
        final int n = nums.size();

        if (n <= 1) return 1;
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(0)) {
                right.add(nums.get(i));
            } else {
                left.add(nums.get(i));
            }
        }
        int ln = left.size();
        int rn = right.size();

        return recursiveWays(left, dp) * recursiveWays(right, dp) % MOD * dp[ln + rn][ln] % MOD;
    }
}
