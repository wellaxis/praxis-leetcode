package com.witalis.praxis.leetcode.task.h3.p283.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 283
 * Name: Move Zeroes
 * URL: <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        moveZeroes(numbers);
        return numbers;
    }

    public void moveZeroes(int[] nums) {
        int sorted = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[sorted++] = nums[i];
            }
        }
        for (int i = sorted; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
