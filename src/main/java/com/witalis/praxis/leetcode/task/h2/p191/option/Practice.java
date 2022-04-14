package com.witalis.praxis.leetcode.task.h2.p191.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 191
 * Name: Number of 1 Bits
 * URL: <a href="https://leetcode.com/problems/number-of-1-bits/">Number of 1 Bits</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return hammingWeight(number);
    }

    public int hammingWeight(int n) {
        int counter = 0;
        for (; n != 0; n >>>= 1)
            if ((n & 1) == 1) counter++;
        return counter;
    }
}
