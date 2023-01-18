package com.witalis.praxis.leetcode.task.h10.p918.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 918
 * Name: Maximum Sum Circular Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-sum-circular-subarray/">Maximum Sum Circular Subarray</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return maxSubarraySumCircular(numbers);
    }

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int max = maxSubarraySum(nums);
        int min = minSubarraySum(nums);

        if (sum - min == 0) return max;
        return Math.max(max, sum - min);
    }

    private int minSubarraySum(int[] nums){
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
            if (sum > 0) sum = 0;
        }

        return min;
    }

    private int maxSubarraySum(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }

        return max;
    }
}