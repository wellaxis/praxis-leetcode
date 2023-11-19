package com.witalis.praxis.leetcode.task.h19.p1877.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1877
 * Name: Minimize Maximum Pair Sum in Array
 * URL: <a href="https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/">Minimize Maximum Pair Sum in Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return minPairSum(numbers);
    }

    public int minPairSum(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        Arrays.sort(nums);

        int maxSum = 0;
        for (int i = 0; i < n / 2; i++) {
            int sum = nums[i] + nums[n - i - 1];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
