package com.witalis.praxis.leetcode.task.h4.p306.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 306
 * Name: Additive Number
 * URL: <a href="https://leetcode.com/problems/additive-number/">Additive Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String number;

    public Boolean process() {
        return isAdditiveNumber(number);
    }

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;

        long num1 = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i > 0 && num.charAt(0) == '0') return false;
            num1 = num1 * 10 + (num.charAt(i) - '0');

            long num2 = 0;
            for (int j = i + 1; j < num.length(); j++) {
                num2 = num2 * 10 + (num.charAt(j) - '0');
                if (j > i + 1 && (num.charAt(i + 1) == '0')) break;

                if (j + 1 < num.length() && isAdditiveNumber(num1, num2, num, j + 1)) return true;
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(long num1, long num2, String num, int sumIndex) {
        if (sumIndex == num.length()) return true;

        String expSum = String.valueOf(num1 + num2);
        if (sumIndex + expSum.length() > num.length()) return false;

        String actualSum = num.substring(sumIndex, sumIndex + expSum.length());
        return actualSum.equals(expSum) && isAdditiveNumber(num2, num1 + num2, num, sumIndex + expSum.length());
    }
}
