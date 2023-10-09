package com.witalis.praxis.leetcode.task.h29.p2843.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2843
 * Name: Count Symmetric Integers
 * URL: <a href="https://leetcode.com/problems/count-symmetric-integers/">Count Symmetric Integers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int low;
    private int high;

    public Integer process() {
        return countSymmetricIntegers(low, high);
    }

    public int countSymmetricIntegers(int low, int high) {
        // count only 2-digit number and 4-digit number
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i < 11 || i >= 100 && i <= 999) {
                continue;
            }
            if (i < 100) {
                count += i % 11 == 0 ? 1 : 0;
            } else {
                int a = i / 1000;
                int b = i / 100 - a * 10;
                int c = i / 10 - a * 100 - b * 10;
                int d = i % 10;
                count += (a + b - c - d) == 0 ? 1 : 0;
            }
        }

        return count;
    }
}
