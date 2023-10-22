package com.witalis.praxis.leetcode.task.h18.p1793.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1793
 * Name: Maximum Score of a Good Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-score-of-a-good-subarray/">Maximum Score of a Good Subarray</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int gap;

    public Integer process() {
        return maximumScore(numbers, gap);
    }

    public int maximumScore(int[] nums, int k) {
        if (nums == null || k < 0) return 0;

        final int n = nums.length;

        int maxScore = nums[k];
        int minValue = nums[k];

        int left = k;
        int right = k;
        while (left > 0 || right < n - 1) {
            if (left == 0) {
                right++;
            } else if (right == n - 1) {
                left--;
            } else if (nums[left - 1] < nums[right + 1]) {
                right++;
            } else {
                left--;
            }

            minValue = Math.min(minValue, Math.min(nums[left], nums[right]));

            int score = minValue * (right - left + 1);
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}
