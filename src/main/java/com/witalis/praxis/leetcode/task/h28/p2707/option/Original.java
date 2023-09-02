package com.witalis.praxis.leetcode.task.h28.p2707.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ID: 2707
 * Name: Extra Characters in a String
 * URL: <a href="https://leetcode.com/problems/extra-characters-in-a-string/">Extra Characters in a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private String[] dictionary;

    public Integer process() {
        return minExtraChar(string, dictionary);
    }

    public int minExtraChar(String s, String[] dictionary) {
        if (s == null || s.isEmpty() || dictionary == null) return 0;

        final int n = s.length();
        final char[] letters = s.toCharArray();
        final Set<String> words = Arrays.stream(dictionary).collect(Collectors.toSet());
        final int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solver(s, words, dp, 0);
    }

    private int solver(String s, Set<String> words, int[] dp, int index) {
        final int n = s.length();

        if (index >= n) return 0;
        if (dp[index] != -1) return dp[index];

        int extraChars = n;
        for (int i = index; i < n; i++) {
            String word = s.substring(index, i + 1);
            int prefix = (words.contains(word)) ? 0 : word.length();
            int suffix = solver(s, words, dp, i + 1);
            extraChars = Math.min(extraChars, prefix + suffix);
        }
        dp[index] = extraChars;

        return extraChars;
    }
}
