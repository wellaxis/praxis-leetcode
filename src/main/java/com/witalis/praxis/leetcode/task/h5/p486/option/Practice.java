package com.witalis.praxis.leetcode.task.h5.p486.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 486
 * Name: Predict the Winner
 * URL: <a href="https://leetcode.com/problems/predict-the-winner/">Predict the Winner</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Boolean process() {
        return predictTheWinner(numbers);
    }

    public boolean predictTheWinner(int[] nums) {
        if (nums == null) return false;

        final int n = nums.length;

        return solver(nums, n, 0, n - 1) >= 0;
    }

    private int solver(int[] nums, int size, int left, int right) {
        if (left == right) return nums[left];

        int leftScore = nums[left] - solver(nums, size, left + 1, right);
        int rightScore = nums[right] - solver(nums, size, left, right - 1);

        return Math.max(leftScore, rightScore);
    }
}
