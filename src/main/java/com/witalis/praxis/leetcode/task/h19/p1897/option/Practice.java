package com.witalis.praxis.leetcode.task.h19.p1897.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1897
 * Name: Redistribute Characters to Make All Strings Equal
 * URL: <a href="https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/">Redistribute Characters to Make All Strings Equal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;

    public Boolean process() {
        return makeEqual(words);
    }

    public boolean makeEqual(String[] words) {
        if (words == null) return false;

        final int n = words.length;
        if (n == 0) return false;

        final int[] frequencies = new int[26];

        char[] letters;
        for (String word : words) {
            letters = word.toCharArray();
            for (char letter : letters)
                frequencies[letter - 'a']++;
        }

        for (int frequency : frequencies)
            if (frequency % n != 0)
                return false;

        return true;
    }
}
