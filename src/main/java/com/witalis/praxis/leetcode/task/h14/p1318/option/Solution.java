package com.witalis.praxis.leetcode.task.h14.p1318.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1318
 * Name: Minimum Flips to Make a OR b Equal to c
 * URL: <a href="https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/">Minimum Flips to Make a OR b Equal to c</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int numberA;
    private int numberB;
    private int numberC;

    public Integer process() {
        return minFlips(numberA, numberB, numberC);
    }

    public int minFlips(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ((a | b) ^ c));
    }
}
