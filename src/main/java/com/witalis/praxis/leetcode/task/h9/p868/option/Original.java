package com.witalis.praxis.leetcode.task.h9.p868.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 868
 * Name: Binary Gap
 * URL: <a href="https://leetcode.com/problems/binary-gap/">Binary Gap</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return binaryGap(number);
    }

    public int binaryGap(int n) {
        if (n <= 1) return 0;

        String value = Integer.toBinaryString(n);

        if (!value.contains("0") && n > 1) return 1;
        if (value.replace("0", "").equals("1")) return 0;

        final char[] bits = value.toCharArray();

        int distance = 0;

        int gap = 1;
        for (char bit : bits) {
            if (bit == '0') {
                gap++;
            } else {
                distance = Math.max(distance, gap);
                gap = 1;
            }
        }

        return distance;
    }
}
