package com.witalis.praxis.leetcode.task.h1.p75.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 75
 * Name: Sort Colors
 * URL: https://leetcode.com/problems/sort-colors/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        sortColors(numbers);
        return numbers;
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int l = 0;
        int r = nums.length - 1;
        int index = -1;

        while (l <= r) {
            if (nums[l] == 0) {
                if (index >= 0) {
                    swap(nums, l, index);
                    index++;
                }
                l++;
            } else if (nums[l] == 1) {
                if (index < 0) index = l;
                l++;
            } else if (nums[l] == 2) {
                swap(nums, l, r);
                r--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
