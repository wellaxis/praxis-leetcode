package com.witalis.praxis.leetcode.task.h5.p461.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 461
 * Name: Hamming Distance
 * URL: <a href="https://leetcode.com/problems/hamming-distance/">Hamming Distance</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number1;
    private int number2;

    public Integer process() {
        return hammingDistance(number1, number2);
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
