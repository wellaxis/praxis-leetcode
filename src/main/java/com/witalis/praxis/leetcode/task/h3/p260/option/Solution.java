package com.witalis.praxis.leetcode.task.h3.p260.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 260
 * Name: Single Number III
 * URL: <a href="https://leetcode.com/problems/single-number-iii/">Single Number III</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return singleNumber(numbers);
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int v : nums) {
            xor ^= v;
        }

        int r = xor & (~(xor - 1));
        int[] res = new int[2];

        for (int v : nums) {
            if ((v & r) != 0) res[0] ^= v;
        }
        res[1] = res[0] ^ xor;

        return res;
    }
}
