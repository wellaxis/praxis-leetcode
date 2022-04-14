package com.witalis.praxis.leetcode.task.h1.p91.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 91
 * Name: Decode Ways
 * URL: <a href="https://leetcode.com/problems/decode-ways/">Decode Ways</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return numDecodings(string);
    }

    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.startsWith("0")) return 0;

        int[] combinations = new int[s.length() + 2];
        combinations[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = Character.getNumericValue(s.charAt(i));
            // single symbol
            int x = (current > 0) ? 1 : 0;
            // double symbol
            int y = 0;
            if (x > 0 && i < s.length() - 1 && current <= 2) {
                int previous = Character.getNumericValue(s.charAt(i + 1));
                if (current * 10 + previous <= 26) y = 1;
            }

            // calculation
            combinations[i] = x * combinations[i + 1] + y * combinations[i + 2];
        }

        return combinations[0];
    }
}
