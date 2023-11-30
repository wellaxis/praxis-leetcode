package com.witalis.praxis.leetcode.task.h17.p1611.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1611
 * Name: Minimum One Bit Operations to Make Integers Zero
 * URL: <a href="https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/">Minimum One Bit Operations to Make Integers Zero</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return minimumOneBitOperations(number);
    }

    public int minimumOneBitOperations(int n) {
        if (n < 0) return 0;

        int operations = 0;

        int mask = 1;
        int index = 0;
        while (mask <= n) {
            if ((n & mask) != 0) {
                operations = (1 << (index + 1)) - 1 - operations;
            }

            mask <<= 1;
            index++;
        }

        return operations;
    }
}
