package com.witalis.praxis.leetcode.task.h5.p438.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 438
 * Name: Find All Anagrams in a String
 * URL: <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams in a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String source;
    private String pattern;

    public List<Integer> process() {
        return findAnagrams(source, pattern);
    }

    public List<Integer> findAnagrams(String s, String p) {
        final int LETTERS = 26;

        if (s == null || p == null) return Collections.emptyList();
        if (s.equals(p)) return Collections.singletonList(0);

        final List<Integer> indices = new ArrayList<>();

        final Integer[] frequencies = new Integer[LETTERS];
        int counter = 0;
        for (char letter : p.toCharArray()) {
            if (frequencies[letter - 'a'] == null) {
                frequencies[letter - 'a'] = 0;
                counter++;
            }
            frequencies[letter - 'a']++;
        }

        final int patternLen = p.length();
        final int sourceLen = s.length();
        final char[] letters = s.toCharArray();

        int matches = 0;
        int index;
        final int maxIndex = patternLen - 1;
        for (int i = 0; i < sourceLen; i++) {
            index = letters[i] - 'a';

            if (frequencies[index] != null) {
                frequencies[index]--;
                if (frequencies[index] == 0) matches++;
            }

            if (matches == counter) indices.add(i - maxIndex);

            if (i >= maxIndex) {
                index = letters[i - maxIndex] - 'a';
                if (frequencies[index] != null) {
                    if (frequencies[index] == 0) matches--;
                    frequencies[index]++;
                }
            }
        }

        return indices;
    }
}
