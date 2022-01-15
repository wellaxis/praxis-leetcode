package com.witalis.praxis.leetcode.task.h1.p31.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 31
 * Name: Next Permutation
 * URL: https://leetcode.com/problems/next-permutation/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        nextPermutation(numbers);
        return numbers;
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        // start with the penultimate element
        for (int i = nums.length - 2; i >= 0; i--) {
            int current = nums[i];
            if (nums[i] < nums[nums.length - 1]) {
                // swap with the smallest larger element
                for (int j = i + 1; j <= nums.length - 1; j++) {
                    if (nums[i] < nums[j]) {
                        nums[i] = nums[j];
                        nums[j] = current;
                        return;
                    }
                }
            } else {
                // shift remaining one position to the left
                if (nums.length - 1 - i >= 0)
                    System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                // maximum is the latest as tail of array
                nums[nums.length - 1] = current;
            }
        }
    }
}
