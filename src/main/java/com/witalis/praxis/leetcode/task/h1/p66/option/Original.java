package com.witalis.praxis.leetcode.task.h1.p66.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 66
 * Name: Plus One
 * URL: https://leetcode.com/problems/plus-one/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] digits;

    public int[] process() {
        return plusOne(digits);
    }

    public int[] plusOne(int[] digits) {
        if (digits == null) return new int[0];

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit < 9) {
                digits[i] = digit + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, digits.length);

        return result;
    }
}
