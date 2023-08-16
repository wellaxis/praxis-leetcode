package com.witalis.praxis.leetcode.task.h3.p239.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ID: 239
 * Name: Sliding Window Maximum
 * URL: <a href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int window;

    public int[] process() {
        return maxSlidingWindow(numbers, window);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        // number of windows
        int[] result = new int[n - k + 1];

        // left & right
        int[] left = new int[n];
        int[] right = new int[n];
        // initialization
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            // left
            if (i % k == 0) left[i] = nums[i];
            else            left[i] = Math.max(left[i - 1], nums[i]);
            // right
            int j = n - i - 1;
            if (j % k == (k - 1)) right[j] = nums[j];
            else                  right[j] = Math.max(right[j + 1], nums[j]);
        }

        // dp
        for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
            result[i] = Math.max(right[i], left[j]);
        }

        return result;
    }
}
