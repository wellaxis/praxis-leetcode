package com.witalis.praxis.leetcode.task.h4.p371.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 371
 * Name: Sum of Two Integers
 * URL: <a href="https://leetcode.com/problems/sum-of-two-integers/">Sum of Two Integers</a>
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
        return getSum(number1, number2);
    }

    public int getSum(int a, int b) {
        return a == 0 ? a ^ b : getSum((a & b) << 1, a ^ b);
    }
}
