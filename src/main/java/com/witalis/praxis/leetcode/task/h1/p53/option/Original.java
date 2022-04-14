package com.witalis.praxis.leetcode.task.h1.p53.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 53
 * Name: Maximum Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return maxSubArray(numbers);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            sum += num;
            if (num > sum) {
                sum = num;
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
