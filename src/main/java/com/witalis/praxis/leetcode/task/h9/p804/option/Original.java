package com.witalis.praxis.leetcode.task.h9.p804.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;

/**
 * ID: 804
 * Name: Unique Morse Code Words
 * URL: <a href="https://leetcode.com/problems/unique-morse-code-words/">Unique Morse Code Words</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;

    public Integer process() {
        return uniqueMorseRepresentations(words);
    }

    private static final Map<Character, String> encoding = Map.ofEntries(
        Map.entry('a', ".-"),
        Map.entry('b', "-..."),
        Map.entry('c', "-.-."),
        Map.entry('d', "-.."),
        Map.entry('e', "."),
        Map.entry('f', "..-."),
        Map.entry('g', "--."),
        Map.entry('h', "...."),
        Map.entry('i', ".."),
        Map.entry('j', ".---"),
        Map.entry('k', "-.-"),
        Map.entry('l', ".-.."),
        Map.entry('m', "--"),
        Map.entry('n', "-."),
        Map.entry('o', "---"),
        Map.entry('p', ".--."),
        Map.entry('q', "--.-"),
        Map.entry('r', ".-."),
        Map.entry('s', "..."),
        Map.entry('t', "-"),
        Map.entry('u', "..-"),
        Map.entry('v', "...-"),
        Map.entry('w', ".--"),
        Map.entry('x', "-..-"),
        Map.entry('y', "-.--"),
        Map.entry('z', "--..")
    );

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null) return 0;

        return (int) Arrays.stream(words).map(Original::encode).distinct().count();
    }

    private static String encode(String word) {
        final var builder = new StringBuilder();
        for (char letter : word.toCharArray()) {
            builder.append(encoding.get(letter));
        }

        return builder.toString();
    }
}
