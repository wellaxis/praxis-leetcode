package com.witalis.praxis.leetcode.task.h5.p461.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 461
 * Name: Hamming Distance
 * URL: <a href="https://leetcode.com/problems/hamming-distance/">Hamming Distance</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number1;
    private int number2;

    public Integer process() {
        return hammingDistance(number1, number2);
    }

    public int hammingDistance(int x, int y) {
        int count = 0;

        int xor = x ^ y;
        while (xor > 0) {
            // Brian Kernighan method to find number of 1's
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }
}
