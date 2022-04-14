package com.witalis.praxis.leetcode.task.h1.p9.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 9
 * Name: Palindrome Number
 * URL: <a href="https://leetcode.com/problems/palindrome-number/">Palindrome Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return isPalindrome(number);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int tmp = x;
        int res = 0;
        while (tmp > 0) {
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }
        return x == res;
    }
}
