package com.witalis.praxis.leetcode.task.h17.p1685.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1685
 * Name: Sum of Absolute Differences in a Sorted Array
 * URL: <a href="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/">Sum of Absolute Differences in a Sorted Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return getSumAbsoluteDifferences(numbers);
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        if (nums == null) return new int[0];

        final int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int[] result = new int[n];

        int prefix = 0;
        for (int i = 0; i < n; i++) {
            int suffix = sum - (prefix + nums[i]);

            int left = i;
            int right = n - (i + 1);

            int leftSum = left * nums[i] - prefix;
            int rightSum = suffix - right * nums[i];

            result[i] = leftSum + rightSum;
            prefix += nums[i];
        }

        return result;
    }
}
