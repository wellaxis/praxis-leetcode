package com.witalis.praxis.leetcode.task.h3.p201.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 201
 * Name: Bitwise AND of Numbers Range
 * URL: <a href="https://leetcode.com/problems/bitwise-and-of-numbers-range/">Bitwise AND of Numbers Range</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int left;
    private int right;

    public Integer process() {
        return rangeBitwiseAnd(left, right);
    }

    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right &= (right - 1);
        }

        return left & right;
    }
}
