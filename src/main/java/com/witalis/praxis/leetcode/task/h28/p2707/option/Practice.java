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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private String[] dictionary;

    public Practice(String string, String[] dictionary) {
        this.string = string;
        this.dictionary = dictionary;
    }

    public Integer process() {
        return minExtraChar(string, dictionary);
    }

    private Set<String> words;
    private int[] dp;

    public int minExtraChar(String s, String[] dictionary) {
        if (s == null || s.isEmpty() || dictionary == null) return 0;

        final int n = s.length();
        this.words = Arrays.stream(dictionary).collect(Collectors.toSet());
        this.dp = new int[n];
        Arrays.fill(dp, -1);

        return solver(s, 0);
    }

    private int solver(String s, int index) {
        final int n = s.length();

        if (index == n) return 0;
        if (dp[index] != -1) return dp[index];

        int extraChars = n;
        for (int i = index; i < n; i++) {
            String word = s.substring(index, i + 1);
            int prefix = (words.contains(word)) ? 0 : i + 1 - index;
            int suffix = solver(s, i + 1);
            extraChars = Math.min(extraChars, prefix + suffix);
        }
        dp[index] = extraChars;

        return extraChars;
    }
}
