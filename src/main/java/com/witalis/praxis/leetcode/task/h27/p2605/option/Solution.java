package com.witalis.praxis.leetcode.task.h27.p2605.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2605
 * Name: Form Smallest Number From Two Digit Arrays
 * URL: <a href="https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/">Form Smallest Number From Two Digit Arrays</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers1;
    private int[] numbers2;

    public Integer process() {
        return minNumber(numbers1, numbers2);
    }

    public int minNumber(int[] nums1, int[] nums2) {
        int[] temp = new int[10];
        for (int i = 0; i < 10; i++) {
            temp[i] = 0;
        }

        int min1 = 11;
        for (int j : nums1) {
            temp[j] = 1;
            if (min1 > j) {
                min1 = j;
            }
        }

        int min2 = 11;
        for (int j : nums2) {
            temp[j]++;
            if (min2 > j) {
                min2 = j;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (temp[i] == 2) {
                return i;
            }
        }

        if (min1 > min2) {
            return min2 * 10 + min1;
        } else {
            return min1 * 10 + min2;
        }
    }
}
