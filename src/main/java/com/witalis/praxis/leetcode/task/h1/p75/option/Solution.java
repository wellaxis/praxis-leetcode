package com.witalis.praxis.leetcode.task.h1.p75.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 75
 * Name: Sort Colors
 * URL: <a href="https://leetcode.com/problems/sort-colors/">Sort Colors</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        sortColors(numbers);
        return numbers;
    }

    // The Dutch National Flag
    public void sortColors(int[] nums) {
        // The three pointers represent the subscripts of numbers 0, 1, 2, respectively.
        int i = -1, j = -1, k = -1;
        for (int n = 0; n < nums.length; n++) {
            if (nums[n] == 0) {
                // Elements are 0, J, K must go backward
                nums[++k] = 2;
                nums[++j] = 1;
                nums[++i] = 0;
            } else if (nums[n] == 1) {
                nums[++k] = 2;
                nums[++j] = 1;
            } else
                nums[++k] = 2;
        }
    }
}
