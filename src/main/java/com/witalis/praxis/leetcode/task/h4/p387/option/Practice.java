package com.witalis.praxis.leetcode.task.h4.p387.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 387
 * Name: First Unique Character in a String
 * URL: <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">First Unique Character in a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return firstUniqChar(string);
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            letters.computeIfPresent(character, (letter, counter) -> ++counter);
            letters.putIfAbsent(character, 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (letters.get(character) == 1) return i;
        }

        return -1;
    }
}
