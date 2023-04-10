package com.witalis.praxis.leetcode.task.h10.p977.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 977
 * Name: Squares of a Sorted Array
 * URL: <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return sortedSquares(numbers);
    }

    public int[] sortedSquares(int[] nums) {
        if (nums == null) return new int[0];

        final int n = nums.length;
        final int[] ans = new int[n];

        if (nums[0] >= 0) {
            for (int i = 0; i < n; i++)
                ans[i] = nums[i] * nums[i];
            return ans;
        }

        int low = 0;
        int high = n - 1;
        int index = n - 1;
        while (low <= high) {
            final int l = nums[low] * nums[low];
            final int h = nums[high] * nums[high];

            if (l >= h) {
                ans[index] = l;
                low++;
            } else {
                ans[index] = h;
                high--;
            }
            index--;
        }

        return ans;
    }
}
