package com.witalis.praxis.leetcode.task.h4.p357.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 357
 * Name: Count Numbers with Unique Digits
 * URL: <a href="https://leetcode.com/problems/count-numbers-with-unique-digits/">Count Numbers with Unique Digits</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return countNumbersWithUniqueDigits(number);
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0) return 0;

        int count = 0;
        int base = 0;
        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                base = (int) Math.pow(9, i);
            } else {
                base *= (10 - (i - 1));
            }
            count += base;
        }

        return count;
    }
}
