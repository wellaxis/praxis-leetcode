package com.witalis.praxis.leetcode.task.h5.p461.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 461
 * Name: Hamming Distance
 * URL: <a href="https://leetcode.com/problems/hamming-distance/">Hamming Distance</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number1;
    private int number2;

    public Integer process() {
        return hammingDistance(number1, number2);
    }

    public int hammingDistance(int x, int y) {
        int distance = 0;

        for (int i = 0; i < 32; i++) {
            if ((x & 1) != (y & 1)) distance++;
            x >>= 1;
            y >>= 1;
        }

        return distance;
    }
}
