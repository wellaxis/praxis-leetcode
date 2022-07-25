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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;

    public String[] process() {
        return findWords(words);
    }

    private static final Set<Character> firstRow = new HashSet<>(Set.of('q','w','e','r','t','y','u','i','o','p'));
    private static final Set<Character> secondRow = new HashSet<>(Set.of('a','s','d','f','g','h','j','k','l'));
    private static final Set<Character> thirdRow = new HashSet<>(Set.of('z','x','c','v','b','n','m'));

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) return new String[0];

        return Arrays.stream(words).filter(Practice::isKeyboard).toArray(String[]::new);
    }

    private static boolean isKeyboard(String word) {
        word = word.toLowerCase();
        char init = word.charAt(0);

        Set<Character> characters;

        if (firstRow.contains(init)) characters = firstRow;
        else if (secondRow.contains(init)) characters = secondRow;
        else if (thirdRow.contains(init)) characters = thirdRow;
        else characters = Collections.emptySet();

        for (int i = 1; i < word.length(); i++) {
            if (!characters.contains(word.charAt(i))) return false;
        }

        return true;
    }
}
