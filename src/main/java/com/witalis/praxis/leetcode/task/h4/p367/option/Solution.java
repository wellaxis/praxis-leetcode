package com.witalis.praxis.leetcode.task.h4.p367.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 367
 * Name: Valid Perfect Square
 * URL: <a href="https://leetcode.com/problems/valid-perfect-square/">Valid Perfect Square</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Boolean process() {
        return isPerfectSquare(number);
    }

    // Newton's method, close to O(1)
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        long t = num / 2 + 1L;
        while (t * t > num) {
            t = (t + num / t) / 2;
        }

        return t * t == num;
    }
}
