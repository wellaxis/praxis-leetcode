package com.witalis.praxis.leetcode.task.h2.p190.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.lang.Character.MIN_RADIX;

/**
 * ID: 190
 * Name: Reverse Bits
 * URL: <a href="https://leetcode.com/problems/reverse-bits/">Reverse Bits</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String bits;

    public Integer process() {
        return reverseBits(bits);
    }

    public int reverseBits(String bits) {
        var unsignedInt = Integer.parseUnsignedInt(bits, MIN_RADIX);
        return reverseBits(unsignedInt);
    }

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            result += (bit << (31 - i));
        }

        return result;
    }
}
