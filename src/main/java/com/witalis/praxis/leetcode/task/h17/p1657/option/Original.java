package com.witalis.praxis.leetcode.task.h17.p1657.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1657
 * Name: Determine if Two Strings Are Close
 * URL: <a href="https://leetcode.com/problems/determine-if-two-strings-are-close/">Determine if Two Strings Are Close</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String word1;
    private String word2;

    public Boolean process() {
        return closeStrings(word1, word2);
    }

    public static final int LETTERS = 26;

    public boolean closeStrings(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) return false;

        int[] letters1 = new int[LETTERS];
        int[] letters2 = new int[LETTERS];

        int len = word1.length();
        for (int i = 0; i < len; i++) {
            letters1[word1.charAt(i) - 'a']++;
            letters2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < LETTERS; i++) {
            int frequency1 = letters1[i];
            int frequency2 = letters2[i];
            if (!((frequency1 == 0 && frequency2 == 0) || (frequency1 != 0 && frequency2 != 0))) return false;
        }

        Arrays.sort(letters1);
        Arrays.sort(letters2);

        for (int i = 0; i < LETTERS; i++) {
            if (letters1[i] != letters2[i]) return false;
        }

        return true;
    }
}
