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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String bits;

    public Integer process() {
        return reverseBits(bits);
    }

    public int reverseBits(String bits) {
        var unsignedInt = Integer.parseUnsignedInt(bits, MIN_RADIX);
        return reverseBits(unsignedInt);
    }

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
