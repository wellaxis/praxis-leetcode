package com.witalis.praxis.leetcode.task.h5.p405.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * ID: 405
 * Name: Convert a Number to Hexadecimal
 * URL: <a href="https://leetcode.com/problems/convert-a-number-to-hexadecimal/">Convert a Number to Hexadecimal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public String process() {
        return toHex(number);
    }

    private static Map<Long, String> hex = Map.ofEntries(
        Map.entry(10L, "a"),
        Map.entry(11L, "b"),
        Map.entry(12L, "c"),
        Map.entry(13L, "d"),
        Map.entry(14L, "e"),
        Map.entry(15L, "f")
    );

    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder builder = new StringBuilder();

        long value = (num > 0) ? num : num + (1L << 32);

        long mod;
        while (value > 0) {
            mod = value % 16;
            if (mod < 10) {
                builder.append(mod);
            } else {
                builder.append(hex.get(mod));
            }
            value /= 16;
        }

        return builder.reverse().toString();
    }
}
