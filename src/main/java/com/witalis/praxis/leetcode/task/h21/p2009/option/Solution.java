package com.witalis.praxis.leetcode.task.h21.p2009.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2009
 * Name: Minimum Number of Operations to Make Array Continuous
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/">Minimum Number of Operations to Make Array Continuous</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return minOperations(numbers);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;

        // sort the input array in ascending order
        Arrays.sort(nums);

        // remove duplicate elements in the sorted array
        int m = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }

        // use a sliding window to find the minimum number of operations
        int ans = n;
        for (int i = 0, j = 0; i < m; ++i) {
            while (j < m && nums[j] - nums[i] <= n - 1) {
                ++j;
            }
            ans = Math.min(ans, n - (j - i));
        }

        return ans;
    }
}
