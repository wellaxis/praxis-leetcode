package com.witalis.praxis.leetcode.task.h8.p748.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 748
 * Name: Shortest Completing Word
 * URL: <a href="https://leetcode.com/problems/shortest-completing-word/">Shortest Completing Word</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String licensePlate;
    private String[] words;

    public String process() {
        return shortestCompletingWord(licensePlate, words);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        if (licensePlate == null || words == null) return "";

        final int[] frequencies = new int[26];
        final char[] letters = licensePlate.replaceAll("\\s", "").toLowerCase().toCharArray();
        for (char letter : letters) {
            if (Character.isLetter(letter)) {
                frequencies[letter - 'a']++;
            }
        }

        String completing = "";
        for (String word : words) {
            if (!completing.isEmpty() && word.length() >= completing.length()) continue;

            int[] frequency = frequencies.clone();
            for (char letter : word.toCharArray()) {
                if (frequencies[letter - 'a'] == 0) continue;

                frequency[letter - 'a']--;
            }
            boolean candidate = true;
            for (int i = 0; i < 26; i++) {
                if (frequency[i] > 0) {
                    candidate = false;
                    break;
                }
            }
            if (candidate) completing = word;
        }

        return completing;
    }
}
