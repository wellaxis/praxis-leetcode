package com.witalis.praxis.leetcode.task.h9.p884.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 884
 * Name: Uncommon Words from Two Sentences
 * URL: <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/">Uncommon Words from Two Sentences</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string1;
    private String string2;

    public String[] process() {
        return uncommonFromSentences(string1, string2);
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        if (s1 == null || s2 == null) return new String[0];

        final Map<String, Integer> words = new HashMap<>();

        for (String word : s1.split(" "))
            words.put(word, words.getOrDefault(word, 0) + 1);
        for (String word : s2.split(" "))
            words.put(word, words.getOrDefault(word, 0) + 1);

        return words.entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey)
            .toArray(String[]::new);
    }
}
