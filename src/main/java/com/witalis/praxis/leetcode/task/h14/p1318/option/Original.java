package com.witalis.praxis.leetcode.task.h14.p1318.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1318
 * Name: Minimum Flips to Make a OR b Equal to c
 * URL: <a href="https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/">Minimum Flips to Make a OR b Equal to c</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) flips++;
            } else {
                if ((a & 1) == 1) flips++;
                if ((b & 1) == 1) flips++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}
