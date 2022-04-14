package com.witalis.praxis.leetcode.task.h1.p66.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 66
 * Name: Plus One
 * URL: <a href="https://leetcode.com/problems/plus-one/">Plus One</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] digits;

    public int[] process() {
        return plusOne(digits);
    }

    public int[] plusOne(int[] digits) {
        if (digits == null) return new int[0];

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
