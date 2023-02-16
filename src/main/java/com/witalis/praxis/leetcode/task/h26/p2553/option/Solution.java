package com.witalis.praxis.leetcode.task.h26.p2553.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2553
 * Name: Separate the Digits in an Array
 * URL: <a href="https://leetcode.com/problems/separate-the-digits-in-an-array/">Separate the Digits in an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return separateDigits(numbers);
    }

    public int[] separateDigits(int[] nums) {
        int length = 0;
        for (int num : nums) {
            length += (int) (Math.log10(num) + 1);
        }

        int[] arr = new int[length];
        int k = arr.length - 1;
        int i = nums.length - 1;
        while (k >= 0 && i >= 0) {
            int n = nums[i];
            while (n > 0) {
                arr[k] = n % 10;
                n = n / 10;
                k--;
            }
            i--;
        }

        return arr;
    }
}
