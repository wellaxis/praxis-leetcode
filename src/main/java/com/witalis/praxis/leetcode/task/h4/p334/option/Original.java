package com.witalis.praxis.leetcode.task.h4.p334.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 334
 * Name: Increasing Triplet Subsequence
 * URL: <a href="https://leetcode.com/problems/increasing-triplet-subsequence/">Increasing Triplet Subsequence</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return increasingTriplet(numbers);
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int len = nums.length;
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];

        leftMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        rightMax[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        for (int i = 1; i < len - 1; i++) {
            if (leftMin[i - 1] < nums[i] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
