package com.witalis.praxis.leetcode.task.p9.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 9
 * Name: Palindrome Number
 * URL: https://leetcode.com/problems/palindrome-number/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Boolean process() {
        return isPalindrome(number);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int digits = (int) (Math.log10(x) + 1);

        while (x > 0) {
            if (x % 10 != x / (int) Math.pow(10, digits - 1))
                return false;

            x %= Math.pow(10, --digits);
            x /= 10;
            digits--;
        }
        return true;
    }
}
