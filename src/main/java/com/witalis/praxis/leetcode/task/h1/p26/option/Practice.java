package com.witalis.praxis.leetcode.task.h1.p26.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 26
 * Name: Remove Duplicates from Sorted Array
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return removeDuplicates(numbers);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[counter - 1]) nums[counter++] = nums[i];
        }
        return counter;
    }
}
