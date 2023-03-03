package com.witalis.praxis.leetcode.task.h8.p748.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 748
 * Name: Shortest Completing Word
 * URL: <a href="https://leetcode.com/problems/shortest-completing-word/">Shortest Completing Word</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String licensePlate;
    private String[] words;

    public String process() {
        return shortestCompletingWord(licensePlate, words);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        String completing = "";

        if (licensePlate == null || words == null) return completing;

        final int[] frequencies = new int[26];
        final char[] letters = licensePlate.toLowerCase().toCharArray();
        for (final char letter : letters) {
            if (Character.isLetter(letter)) {
                frequencies[letter - 'a']++;
            }
        }

        for (final String word : words) {
            if (!completing.isEmpty() && word.length() >= completing.length()) continue;

            final int[] frequency = new int[26];
            for (final char letter : word.toCharArray()) {
                frequency[letter - 'a']++;
            }
            boolean candidate = true;
            for (int i = 0; i < 26; i++) {
                if (frequencies[i] > 0 && frequency[i] < frequencies[i]) {
                    candidate = false;
                    break;
                }
            }
            if (candidate) completing = word;
        }

        return completing;
    }
}
