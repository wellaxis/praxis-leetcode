package com.witalis.praxis.leetcode.task.h30.p2917.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2917
 * Name: Find the K-or of an Array
 * URL: <a href="https://leetcode.com/problems/find-the-k-or-of-an-array/">Find the K-or of an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int elements;

    public Integer process() {
        return findKOr(numbers, elements);
    }

    public int findKOr(int[] nums, int k) {
        int bit = 0;
        int len = nums.length;
        int res = 0;

        for (; ; ) {
            int nSet = 0;
            int nZero = 0;
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                nSet += num & 1;
                num = num >> 1;
                nums[i] = num;
                if (num <= 0) {
                    nZero++;
                }
            }

            if (nSet >= k) {
                res += 1 << bit;
            }
            if (nZero == len) {
                break;
            }
            bit++;
        }

        return res;
    }
}
