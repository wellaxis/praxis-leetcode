package com.witalis.praxis.leetcode.task.h3.p239.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 239
 * Name: Sliding Window Maximum
 * URL: <a href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int window;

    public int[] process() {
        return maxSlidingWindow(numbers, window);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        final int n = nums.length;
        final int[] maxes = new int[n - k + 1];
        final Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) {
                maxes[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return maxes;
    }
}
