package com.witalis.praxis.leetcode.task.h9.p884.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 884
 * Name: Uncommon Words from Two Sentences
 * URL: <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/">Uncommon Words from Two Sentences</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string1;
    private String string2;

    public String[] process() {
        return uncommonFromSentences(string1, string2);
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        if (s1 == null || s2 == null) return new String[0];

        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        Map<String, Integer> words = new HashMap<>();
        for (String word : words1) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        List<String> uncommonWords = new ArrayList<>();
        words.entrySet().stream().filter(e -> e.getValue() == 1).forEach(e -> uncommonWords.add(e.getKey()));

        return uncommonWords.toArray(String[]::new);
    }
}
