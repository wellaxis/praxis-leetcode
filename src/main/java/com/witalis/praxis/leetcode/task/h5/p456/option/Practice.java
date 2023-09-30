package com.witalis.praxis.leetcode.task.h5.p456.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 456
 * Name: 132 Pattern
 * URL: <a href="https://leetcode.com/problems/132-pattern/">132 Pattern</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Boolean process() {
        return find132pattern(numbers);
    }

    public boolean find132pattern(int[] nums) {
        if (nums == null) return false;

        final int n = nums.length;
        if (n < 3) return false;

        final Deque<Integer> stack = new ArrayDeque<>();

        int maxK = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int k = nums[i];

            if (nums[i] < maxK) return true;

            while (!stack.isEmpty() && stack.peek() < k) {
                maxK = stack.pop();
            }
            stack.push(k);
        }

        return false;
    }
}
