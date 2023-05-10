package com.witalis.praxis.leetcode.task.h10.p922.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 922
 * Name: Sort Array By Parity II
 * URL: <a href="https://leetcode.com/problems/sort-array-by-parity-ii/">Sort Array By Parity II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return sortArrayByParityII(numbers);
    }

    public int[] sortArrayByParityII(int[] nums) {
        final int n = nums.length;

        for (int i = 0, j = 1; i < n; i += 2, j += 2) {
            while (i < n && nums[i] % 2 == 0)
                i += 2;
            while (j < n && nums[j] % 2 == 1)
                j += 2;
            if (i < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return nums;
    }
}
