package com.witalis.praxis.leetcode.task.h10.p905.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 905
 * Name: Sort Array By Parity
 * URL: <a href="https://leetcode.com/problems/sort-array-by-parity/">Sort Array By Parity</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return sortArrayByParity(numbers);
    }

    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] % 2 == 1 && nums[r] % 2 == 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if (nums[l] % 2 == 0) ++l;
            if (nums[r] % 2 == 1) --r;
        }

        return nums;
    }
}
