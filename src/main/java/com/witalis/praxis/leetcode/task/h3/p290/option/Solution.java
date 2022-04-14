package com.witalis.praxis.leetcode.task.h3.p290.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 290
 * Name: Word Pattern
 * URL: <a href="https://leetcode.com/problems/word-pattern/">Word Pattern</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String pattern;
    private String string;

    public Boolean process() {
        return wordPattern(pattern, string);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, Integer> charToIndex = new HashMap<>();
        Map<String, Integer> stringToIndex = new HashMap<>();

        for (Integer i = 0; i < pattern.length(); ++i)
            if (charToIndex.put(pattern.charAt(i), i) != stringToIndex.put(words[i], i))
                return false;

        return true;
    }
}
