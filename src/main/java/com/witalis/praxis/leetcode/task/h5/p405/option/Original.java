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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public String process() {
        return toHex(number);
    }

    private static Map<Integer, String> hex = Map.ofEntries(
        Map.entry(10, "a"),
        Map.entry(11, "b"),
        Map.entry(12, "c"),
        Map.entry(13, "d"),
        Map.entry(14, "e"),
        Map.entry(15, "f")
    );

    public String toHex(int num) {
        StringBuilder builder = new StringBuilder();

        if (num > 0) {
            int mod;
            while (num > 0) {
                mod = num % 16;
                if (mod < 10) {
                    builder.append(mod);
                } else {
                    builder.append(hex.get(mod));
                }
                num /= 16;
            }
        } else if (num < 0) {
            long longNum = num + (1L << 32);

            long mod;
            while (longNum > 0) {
                mod = longNum % 16;
                if (mod < 10) {
                    builder.append(mod);
                } else {
                    builder.append(hex.get((int) mod));
                }
                longNum /= 16;
            }
        } else {
            builder.append("0");
        }

        return builder.reverse().toString();
    }
}
