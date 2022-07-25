package com.witalis.praxis.leetcode.task.h6.p500.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 500
 * Name: Keyboard Row
 * URL: <a href="https://leetcode.com/problems/keyboard-row/">Keyboard Row</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;

    public String[] process() {
        return findWords(words);
    }

    private static final String ROW_FIRST = "qwertyuiopg";
    private static final String ROW_SECOND = "asdfghjklg";
    private static final String ROW_THIRD = "zxcvbnmg";

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) return new String[0];

        List<String> keyboardWords = new LinkedList<>();

        String row;
        for (String word : words) {
            String temp = word.toLowerCase();
            String init = temp.substring(0, 1);

            if (ROW_FIRST.contains(init)) row = ROW_FIRST;
            else if (ROW_SECOND.contains(init)) row = ROW_SECOND;
            else if (ROW_THIRD.contains(init)) row = ROW_THIRD;
            else row = "";

            if (temp.replaceAll("[" + row + "]", "").isEmpty()) keyboardWords.add(word);
        }

        return keyboardWords.toArray(String[]::new);
    }
}
