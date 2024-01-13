package com.witalis.praxis.leetcode.task.h14.p1347.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1347
 * Name: Minimum Number of Steps to Make Two Strings Anagram
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/">Minimum Number of Steps to Make Two Strings Anagram</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String source;
    private String target;

    public Integer process() {
        return minSteps(source, target);
    }

    public int minSteps(String s, String t) {
        if (s == null || t == null) return 0;

        char[] sLetters = s.toCharArray();
        char[] tLetters = t.toCharArray();

        if (sLetters.length != tLetters.length) return -1;

        int[] sFrequencies = new int[26];
        for (char letter : sLetters)
            sFrequencies[letter - 'a']++;

        int[] tFrequencies = new int[26];
        for (char letter : tLetters)
            tFrequencies[letter - 'a']++;

        int steps = 0;
        for (int i = 0; i < 26; i++)
            steps += Math.abs(sFrequencies[i] - tFrequencies[i]);

        return steps / 2;
    }
}
