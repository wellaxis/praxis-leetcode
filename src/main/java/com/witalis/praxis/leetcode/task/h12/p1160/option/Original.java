package com.witalis.praxis.leetcode.task.h12.p1160.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1160
 * Name: Find Words That Can Be Formed by Characters
 * URL: <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/">Find Words That Can Be Formed by Characters</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;
    private String chars;

    public Integer process() {
        return countCharacters(words, chars);
    }

    public int countCharacters(String[] words, String chars) {
        if (words == null || chars == null || chars.isEmpty()) return 0;

        final int[] charFrequencies = getFrequencies(chars);

        return Arrays.stream(words)
            .filter(word -> isGood(getFrequencies(word), charFrequencies))
            .map(String::length)
            .mapToInt(Integer::intValue)
            .sum();
    }

    private static int[] getFrequencies(String string) {
        final int[] frequencies = new int[26];

        char[] letters = string.toCharArray();
        for (char letter : letters)
            frequencies[letter - 'a']++;

        return frequencies;
    }

    private static boolean isGood(int[] wordFrequencies, int[] charFrequencies) {
        for (int i = 0; i < 26; i++)
            if (wordFrequencies[i] > charFrequencies[i])
                return false;
        return true;
    }
}
