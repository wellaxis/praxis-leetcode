package com.witalis.praxis.leetcode.task.p30.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 30
 * Name: Substring with Concatenation of All Words
 * URL: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private String[] words;

    public List<Integer> process() {
        return findSubstring(string, words);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty()) return Collections.emptyList();
        if (words == null || words.length == 0) return Collections.emptyList();

        List<Integer> indices = new ArrayList<>();

        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            shiftSubstring(s, words, indices, i);
        }
        return indices;
    }

    private void shiftSubstring(String s, String[] words, List<Integer> indices, int offset) {
        s = s.substring(offset);
        int wordLen = words[0].length();
        int subLen = words.length * wordLen;

        int counter = 0;
        while (counter <= s.length() - subLen) {
            if (checkSubstring(s.substring(counter, counter + subLen), words, wordLen)) {
                indices.add(counter + offset);
            }
            counter += wordLen;
        }
    }

    private boolean checkSubstring(String s, String[] words, int size) {
        List<String> wordsList = Arrays.asList(words);

        List<String> partsList = new ArrayList<>();
        for (int i = 0; i < s.length(); i += size) {
            partsList.add(s.substring(i, Math.min(s.length(), i + size)));
        }
        partsList.sort(Comparator.naturalOrder());
        wordsList.sort(Comparator.naturalOrder());
        return partsList.equals(wordsList);
    }
}
