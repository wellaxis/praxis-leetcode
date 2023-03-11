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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;

    public Integer process() {
        return uniqueMorseRepresentations(words);
    }

    private static final String[] encoding = new String[] {
        ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
        "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null) return 0;

        final Set<String> encodedWords = new HashSet<>();
        for (final String word : words) encodedWords.add(encode(word));

        return encodedWords.size();
    }

    private static String encode(String word) {
        final var builder = new StringBuilder();
        final var letters = word.toCharArray();
        for (final char letter : letters) {
            builder.append(encoding[letter - 'a']);
        }

        return builder.toString();
    }
}
