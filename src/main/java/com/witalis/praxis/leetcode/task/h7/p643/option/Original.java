package com.witalis.praxis.leetcode.task.h7.p643.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 643
 * Name: Maximum Average Subarray I
 * URL: <a href="https://leetcode.com/problems/maximum-average-subarray-i/">Maximum Average Subarray I</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int length;

    public Double process() {
        return findMaxAverage(numbers, length);
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || k <= 0) return 0;

        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];

        double max = (double) sum / k;
        for (int i = 1; i <= nums.length - k; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            max = Math.max(max, (double) sum / k);
        }

        return max;
    }
}
