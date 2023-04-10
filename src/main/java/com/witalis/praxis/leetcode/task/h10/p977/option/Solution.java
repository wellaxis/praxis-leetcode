package com.witalis.praxis.leetcode.task.h10.p977.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 977
 * Name: Squares of a Sorted Array
 * URL: <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return sortedSquares(numbers);
    }

    public int[] sortedSquares(int[] nums) {
        final int n = nums.length;
        final int[] ans = new int[n];

        int i = n - 1;
        for (int l = 0, r = n - 1; l <= r; )
            if (Math.abs(nums[l]) > Math.abs(nums[r]))
                ans[i--] = nums[l] * nums[l++];
            else
                ans[i--] = nums[r] * nums[r--];

        return ans;
    }
}
