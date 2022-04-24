package com.witalis.praxis.leetcode.task.h3.p201.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;

/**
 * ID: 201
 * Name: Bitwise AND of Numbers Range
 * URL: <a href="https://leetcode.com/problems/bitwise-and-of-numbers-range/">Bitwise AND of Numbers Range</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int left;
    private int right;

    public Integer process() {
        return rangeBitwiseAnd(left, right);
    }

    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0 || left == right) return left;

        int size = Integer.toBinaryString(left).length();

        BitSet bitwise = new BitSet(size);
        for (int index = 0; index < size; index++) {
            boolean accept = true;

            for (int number = left; number <= right; number++) {
                if (!BitSet.valueOf(new long[] {number}).get(0)) {
                    accept = false;
                    break;
                }
            }

            if (accept) {
                bitwise.set(index);
            }

            left >>= 1;
            right >>= 1;
        }

        long[] values = bitwise.toLongArray();

        return (values.length > 0) ? (int) values[0] : 0;
    }
}
