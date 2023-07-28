package com.witalis.praxis.leetcode.task.h5.p486.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 486
 * Name: Predict the Winner
 * URL: <a href="https://leetcode.com/problems/predict-the-winner/">Predict the Winner</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return predictTheWinner(numbers);
    }

    public boolean predictTheWinner(int[] nums) {
        if (nums == null) return false;

        final int n = nums.length;

        int score = solver(nums, n, 0, 0, n - 1);

        return score >= 0;
    }

    private int solver(int[] nums, int size, int step, int left, int right) {
        if (left == size || right == -1 || left > right) return 0;

        if (step == 0) {
            return Math.max(
                nums[left] + solver(nums, size, 1, left + 1, right),
                nums[right] + solver(nums, size, 1, left, right - 1)
            );
        } else {
            return Math.min(
                -nums[left] + solver(nums, size, 0, left + 1, right),
                -nums[right] + solver(nums, size, 0, left, right - 1)
            );
        }
    }
}
