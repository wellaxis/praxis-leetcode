package com.witalis.praxis.leetcode.task.h1.p87.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 87
 * Name: Scramble String
 * URL: <a href="https://leetcode.com/problems/scramble-string/">Scramble String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string1;
    private String string2;

    public Solution(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public Boolean process() {
        return isScramble(string1, string2);
    }

    private Boolean[][][] dp;
    private char[] chars1;
    private char[] chars2;

    public boolean isScramble(String s1, String s2) {
        dp = new Boolean[s1.length()][s2.length()][s1.length() + 1];
        chars1 = s1.toCharArray();
        chars2 = s2.toCharArray();

        return isScramble(0, 0, s1.length());
    }

    private boolean isScramble(int s1Pos, int s2Pos, int len) {
        if (len == 1) {
            return chars1[s1Pos] == chars2[s2Pos];
        }
        if (dp[s1Pos][s2Pos][len] != null) {
            return dp[s1Pos][s2Pos][len];
        }

        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];

        for (int i = 0; i < len; i++) {
            s1Chars[chars1[i + s1Pos] - 'a']++;
            s2Chars[chars2[i + s2Pos] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                return dp[s1Pos][s2Pos][len] = false;
            }
        }

        for (int i = 1; i < len; i++) {
            if (isScramble(s1Pos, s2Pos, i)
                && isScramble(s1Pos + i, s2Pos + i, len - i)) {
                return dp[s1Pos][s2Pos][len] = true;
            }
            if (isScramble(s1Pos, s2Pos + len - i, i)
                && isScramble(s1Pos + i, s2Pos, len - i)) {
                return dp[s1Pos][s2Pos][len] = true;
            }
        }
        return dp[s1Pos][s2Pos][len] = false;
    }
}
