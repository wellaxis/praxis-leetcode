package com.witalis.praxis.leetcode.task.h12.p1160.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1160
 * Name: Find Words That Can Be Formed by Characters
 * URL: <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/">Find Words That Can Be Formed by Characters</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;
    private String chars;

    public Integer process() {
        return countCharacters(words, chars);
    }

    public int countCharacters(String[] words, String chars) {
        if (words == null || chars == null || chars.isEmpty()) return 0;

        final int[] charFrequencies = getFrequencies(chars);

        int count = 0;
        for (String word : words)
            if (isGood(getFrequencies(word), charFrequencies))
                count += word.length();

        return count;
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
