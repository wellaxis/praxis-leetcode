package com.witalis.praxis.leetcode.task.h14.p1318.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1318
 * Name: Minimum Flips to Make a OR b Equal to c
 * URL: <a href="https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/">Minimum Flips to Make a OR b Equal to c</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int numberA;
    private int numberB;
    private int numberC;

    public Integer process() {
        return minFlips(numberA, numberB, numberC);
    }

    public int minFlips(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 0;

        int flips = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((c >> i & 1) == 1) {
                flips += ((a >> i & 1) == 0 && (b >> i & 1) == 0) ? 1 : 0;
            } else {
                flips += (a >> i & 1) + (b >> i & 1);
            }
        }

        return flips;
    }
}
