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
 * URL: https://leetcode.com/problems/word-pattern/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String pattern;
    private String string;

    public Boolean process() {
        return wordPattern(pattern, string);
    }

    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) return false;

        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> cache = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (cache.containsKey(ch)) {
                if (!cache.get(ch).equals(words[i])) return false;
            } else {
                if (cache.containsValue(words[i])) return false;
                cache.put(ch, words[i]);
            }
        }

        return true;
    }
}
