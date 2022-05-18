package com.witalis.praxis.leetcode.task.h3.p209.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 209
 * Name: Minimum Size Subarray Sum
 * URL: <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int target;

    public Integer process() {
        return minSubArrayLen(target, numbers);
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (target <= 0 || nums == null || nums.length == 0) return 0;

        int minLength = Integer.MAX_VALUE;

        int sum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                sum -= nums[index];
                minLength = Math.min(minLength, i - index + 1);
                index++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
