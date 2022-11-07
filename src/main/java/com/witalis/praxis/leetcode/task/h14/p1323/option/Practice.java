package com.witalis.praxis.leetcode.task.h14.p1323.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1323
 * Name: Maximum 69 Number
 * URL: <a href="https://leetcode.com/problems/maximum-69-number/">Maximum 69 Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return maximum69Number(number);
    }

    public int maximum69Number (int num) {
        if (num <= 0) return num;

        int power = (int) Math.pow(10, (int) Math.log10(num));

        int digits = num;
        while (power > 0) {
            if (digits / power == 6) {
                num += 3 * power;
                break;
            }
            digits = digits % power;
            power /= 10;
        }

        return num;
    }
}
