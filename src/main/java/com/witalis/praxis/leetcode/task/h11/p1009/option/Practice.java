package com.witalis.praxis.leetcode.task.h11.p1009.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1009
 * Name: Complement of Base 10 Integer
 * URL: <a href="https://leetcode.com/problems/complement-of-base-10-integer/">Complement of Base 10 Integer</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return bitwiseComplement(number);
    }

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int complement = 0;

        int base = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                complement = complement + (int) Math.pow(2, base);
            }
            base++;
            n >>= 1;
        }

        return complement;
    }
}
