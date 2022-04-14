package com.witalis.praxis.leetcode.task.h1.p91.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 91
 * Name: Decode Ways
 * URL: <a href="https://leetcode.com/problems/decode-ways/">Decode Ways</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return numDecodings(string);
    }

    public int numDecodings(String s) {
        if (s == null || s.isBlank() || s.startsWith("0")) return 0;

        int[] ways = new int[s.length() + 1];
        ways[s.length()] = 1;

        // ways[i] = single * ways[i + 1] + double * ways[i + 2]
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = s.charAt(i) - '0';
            if (current == 0) continue;

            // single symbol
            ways[i] = ways[i + 1];

            // double symbol
            if (i < s.length() - 1 && current <= 2) {
                int previous = s.charAt(i + 1) - '0';
                if (current * 10 + previous <= 26) {
                    ways[i] += ways[i + 2];
                }
            }
        }

        return ways[0];
    }
}
