package com.witalis.praxis.leetcode.task.h2.p190.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.lang.Character.MIN_RADIX;

/**
 * ID: 190
 * Name: Reverse Bits
 * URL: https://leetcode.com/problems/reverse-bits/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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

        for (int i = 0; i < Integer.SIZE; i++) {
            result = result << 1;
            if ((n & 1) > 0) result++;
            n = n >> 1;
        }

        return result;
    }
}
