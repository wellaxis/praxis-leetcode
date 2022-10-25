package com.witalis.praxis.leetcode.task.h7.p693.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 693
 * Name: Binary Number with Alternating Bits
 * URL: <a href="https://leetcode.com/problems/binary-number-with-alternating-bits/">Binary Number with Alternating Bits</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Boolean process() {
        return hasAlternatingBits(number);
    }

    public boolean hasAlternatingBits(int n) {
        if (n <= 0) return false;

        boolean even = (n & 1) == 0;
        while (n > 0) {
            n >>= 1;
            if (even == ((n & 1) == 0)) return false;
            even = !even;
        }

        return true;
    }
}
