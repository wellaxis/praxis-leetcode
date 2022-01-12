package com.witalis.praxis.leetcode.task.h1.p26.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 26
 * Name: Remove Duplicates from Sorted Array
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return removeDuplicates(numbers);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[counter - 1]) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}
