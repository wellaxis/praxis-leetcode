package com.witalis.praxis.leetcode.task.h10.p907.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * ID: 907
 * Name: Sum of Subarray Minimums
 * URL: <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">Sum of Subarray Minimums</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] array;

    public Integer process() {
        return sumSubarrayMins(array);
    }

    public static final int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        if (arr == null) return 0;

        final int n = arr.length;

        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], n);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                dp[1][stack.pop()] = i;
            }
            dp[0][i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        long sum = 0L;
        for (int i = 0; i < n; ++i) {
            sum += (long) (i - dp[0][i]) * (dp[1][i] - i) % MOD * arr[i] % MOD;
            sum %= MOD;
        }

        return (int) sum;
    }
}
