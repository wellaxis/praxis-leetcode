package com.witalis.praxis.leetcode.task.h2.p191.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 191
 * Name: Number of 1 Bits
 * URL: https://leetcode.com/problems/number-of-1-bits/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return hammingWeight(number);
    }

    public int hammingWeight(int n) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) counter++;
            n >>>= 1;
        }
        return counter;
    }
}
