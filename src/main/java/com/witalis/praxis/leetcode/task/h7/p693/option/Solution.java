package com.witalis.praxis.leetcode.task.h7.p693.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 693
 * Name: Binary Number with Alternating Bits
 * URL: <a href="https://leetcode.com/problems/binary-number-with-alternating-bits/">Binary Number with Alternating Bits</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Boolean process() {
        return hasAlternatingBits(number);
    }

    public boolean hasAlternatingBits(int n) {
        return (n & (n >> 1)) == 0 && (n | (n >> 2)) == n;
    }
}
