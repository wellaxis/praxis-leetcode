package com.witalis.praxis.leetcode.task.h9.p868.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;

/**
 * ID: 868
 * Name: Binary Gap
 * URL: <a href="https://leetcode.com/problems/binary-gap/">Binary Gap</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return binaryGap(number);
    }

    public int binaryGap(int n) {
        if (n <= 1) return 0;

        int distance = 0;

        int previous = -1;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                if (previous == -1) {
                    previous = i;
                } else {
                    distance = Math.max(distance, i - previous);
                    previous = i;
                }
            }
        }

        return distance;
    }
}
