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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word: words) {
            wordsMap.computeIfPresent(word, (key, value) -> ++value);
            wordsMap.putIfAbsent(word, 1);
        }

        Map<String, Integer> cacheMap = new HashMap<>();

        for (int i = 0; i < wordLen; i++) {
            int quantity = 0;
            int position = i;

            cacheMap.clear();

            int counter = i;
            while (counter <= s.length() - wordLen) {
                String item = s.substring(counter, counter + wordLen);

                if (wordsMap.containsKey(item)) {
                    cacheMap.computeIfPresent(item, (key, value) -> value + 1);
                    cacheMap.putIfAbsent(item, 1);

                    quantity++;

                    // check overflow
                    while (cacheMap.get(item) > wordsMap.get(item)) {
                        String back = s.substring(position, position + wordLen);
                        cacheMap.computeIfPresent(back, (key, value) -> value - 1);
                        quantity--;
                        position += wordLen;
                    }

                    // check entrance
                    if (quantity == words.length) {
                        indices.add(position);

                        // rotate step
                        String back = s.substring(position, position + wordLen);
                        cacheMap.computeIfPresent(back, (key, value) -> value - 1);
                        quantity--;
                        position += wordLen;
                    }
                } else {
                    cacheMap.clear();
                    quantity = 0;
                    position = counter + wordLen;
                }

                counter += wordLen;
            }
        }

        return indices;
    }
}
