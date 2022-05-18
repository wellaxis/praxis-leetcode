package com.witalis.praxis.leetcode.task.h3.p209.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 209
 * Name: Minimum Size Subarray Sum
 * URL: <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray Sum</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int target;

    public Integer process() {
        return minSubArrayLen(target, numbers);
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (target <= 0 || nums == null || nums.length == 0) return 0;

        int minLength = Integer.MAX_VALUE;

        int sum = 0;
        int low = 0;
        int high = 0;
        while (high <= nums.length) {
            if (sum >= target) {
                sum -= nums[low];
                minLength = Math.min(minLength, high - low);
                low++;
            } else {
                if (high < nums.length) sum += nums[high];
                high++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
