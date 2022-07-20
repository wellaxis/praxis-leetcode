package com.witalis.praxis.leetcode.task.h2.p152.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 152
 * Name: Maximum Product Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-product-subarray/">Maximum Product Subarray</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return maxProduct(numbers);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int result = nums[0];

        int preMax = nums[0];
        int preMin = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(preMax * nums[i], preMin * nums[i]);
            curMax = Math.max(curMax, nums[i]);
            curMin = Math.min(preMax * nums[i], preMin * nums[i]);
            curMin = Math.min(curMin, nums[i]);
            if (curMax > result) result = curMax;
            preMax = curMax;
            preMin = curMin;
        }

        return result;
    }
}
