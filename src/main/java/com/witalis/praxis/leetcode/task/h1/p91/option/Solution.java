package com.witalis.praxis.leetcode.task.h1.p91.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 91
 * Name: Decode Ways
 * URL: <a href="https://leetcode.com/problems/decode-ways/">Decode Ways</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return numDecodings(string);
    }

    public int numDecodings(String s) {
        int[] f = new int[s.length() + 1];
        f[0] = 1;

        int last = 0;
        int last2 = 0;
        for (int i = 0; i < s.length(); i++) {
            last = s.charAt(i) - '0';
            last2 = last2 % 10 * 10 + last;

            if (last > 0) f[i + 1] = f[i];
            if (last2 > 9 && last2 < 27) f[i + 1] += f[i - 1];
        }

        return f[s.length()];
    }
}
