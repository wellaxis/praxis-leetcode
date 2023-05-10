package com.witalis.praxis.leetcode.task.h10.p922.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 922
 * Name: Sort Array By Parity II
 * URL: <a href="https://leetcode.com/problems/sort-array-by-parity-ii/">Sort Array By Parity II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return sortArrayByParityII(numbers);
    }

    public int[] sortArrayByParityII(int[] nums) {
        if (nums == null) return new int[0];

        final int n = nums.length;

        int even = 0;
        int odd = 1;
        while (true) {
            while (even < n && (nums[even] & 1) == 0) even += 2;
            while (odd < n && (nums[odd] & 1) != 0) odd += 2;

            if (even >= n || odd >= n) return nums;

            int temp = nums[odd];
            nums[odd] = nums[even];
            nums[even] = temp;
        }
    }
}
