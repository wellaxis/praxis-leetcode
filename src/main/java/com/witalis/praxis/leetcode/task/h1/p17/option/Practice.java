package com.witalis.praxis.leetcode.task.h1.p17.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * ID: 17
 * Name: Letter Combinations of a Phone Number
 * URL: <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String digits;

    public List<String> process() {
        return letterCombinations(digits);
    }

    public static final Map<Character, List<String>> buttons = Map.of(
        '2', List.of("a", "b", "c"),
        '3', List.of("d", "e", "f"),
        '4', List.of("g", "h", "i"),
        '5', List.of("j", "k", "l"),
        '6', List.of("m", "n", "o"),
        '7', List.of("p", "q", "r", "s"),
        '8', List.of("t", "u", "v"),
        '9', List.of("w", "x", "y", "z")
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();

        List<String> combinations = List.of("");

        for (char letter: digits.toCharArray()) {
            List<String> values = buttons.get(letter);

            List<String> tmp = new ArrayList<>();
            for (String combination: combinations) {
                for (String symbol: values) {
                    tmp.add(combination + symbol);
                }
            }
            combinations = tmp;
        }

        return combinations;
    }
}
