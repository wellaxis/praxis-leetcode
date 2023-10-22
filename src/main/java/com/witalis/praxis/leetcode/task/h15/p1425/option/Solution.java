package com.witalis.praxis.leetcode.task.h15.p1425.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 1425
 * Name: Constrained Subsequence Sum
 * URL: <a href="https://leetcode.com/problems/constrained-subsequence-sum/">Constrained Subsequence Sum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int gap;

    public Integer process() {
        return constrainedSubsetSum(numbers, gap);
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int dp[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() > k) {
                queue.poll();
            }

            dp[i] = (!queue.isEmpty() ? dp[queue.peek()] : 0) + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] < dp[i]) {
                queue.pollLast();
            }

            if (dp[i] > 0) {
                queue.offer(i);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int num : dp) {
            ans = Math.max(ans, num);
        }

        return ans;
    }
}
