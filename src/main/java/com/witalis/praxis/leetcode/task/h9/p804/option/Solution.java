package com.witalis.praxis.leetcode.task.h9.p804.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 804
 * Name: Unique Morse Code Words
 * URL: <a href="https://leetcode.com/problems/unique-morse-code-words/">Unique Morse Code Words</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;

    public Integer process() {
        return uniqueMorseRepresentations(words);
    }

    public int uniqueMorseRepresentations(String[] words) {
        final String[] morse = {".-",   "-...", "-.-.", "-..",  ".",   "..-.", "--.",  "....", "..",
            ".---", "-.-",  ".-..", "--",   "-.",  "---",  ".--.", "--.-", ".-.",
            "...",  "-",    "..-",  "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> transformations = new HashSet<>();
        for (final String word : words) {
            StringBuilder transformation = new StringBuilder();
            for (final char c : word.toCharArray())
                transformation.append(morse[c - 'a']);
            transformations.add(transformation.toString());
        }

        return transformations.size();
    }
}
