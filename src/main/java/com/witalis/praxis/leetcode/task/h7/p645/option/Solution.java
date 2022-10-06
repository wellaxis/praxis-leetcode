package com.witalis.praxis.leetcode.task.h7.p645.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 645
 * Name: Set Mismatch
 * URL: <a href="https://leetcode.com/problems/set-mismatch/">Set Mismatch</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return findErrorNums(numbers);
    }

    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        int xor0 = 0;
        int xor1 = 0;

        for (int n : nums) xor ^= n;

        for (int i = 1; i <= nums.length; i++) xor ^= i;

        int mostRightBit = xor & -xor;

        for (int n : nums) {
            if ((n & mostRightBit) != 0)
                xor1 ^= n;
            else
                xor0 ^= n;
        }

        for (int i = 1; i <= nums.length; i++) {
            if ((i & mostRightBit) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }

        for (int num : nums) {
            if (num == xor0) return new int[] {xor0, xor1};
        }

        return new int[] {xor1, xor0};
    }
}
