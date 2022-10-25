package com.witalis.praxis.leetcode.task.h7.p693.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 693
 * Name: Binary Number with Alternating Bits
 * URL: <a href="https://leetcode.com/problems/binary-number-with-alternating-bits/">Binary Number with Alternating Bits</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return hasAlternatingBits(number);
    }

    public boolean hasAlternatingBits(int n) {
        if (n <= 0) return false;

        while (n > 0) {
            if ((n & 1) == ((n >> 1) & 1)) return false;
            n >>= 1;
        }

        return true;
    }
}
