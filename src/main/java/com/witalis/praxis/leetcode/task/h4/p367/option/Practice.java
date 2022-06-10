package com.witalis.praxis.leetcode.task.h4.p367.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 367
 * Name: Valid Perfect Square
 * URL: <a href="https://leetcode.com/problems/valid-perfect-square/">Valid Perfect Square</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return isPerfectSquare(number);
    }

    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        long min = 1;
        long max = num;
        while (min <= max) {
            long mid = min + (max - min) / 2;
            long square = mid * mid;
            if (square == num) return true;
            if (square > num) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return false;
    }
}
