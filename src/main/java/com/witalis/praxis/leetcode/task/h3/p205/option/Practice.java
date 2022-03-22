package com.witalis.praxis.leetcode.task.h3.p205.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 205
 * Name: Isomorphic Strings
 * URL: https://leetcode.com/problems/isomorphic-strings/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String source;
    private String target;

    public Boolean process() {
        return isIsomorphic(source, target);
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Character> matching = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (matching.containsKey(sc)) {
                if (matching.get(sc) != tc) return false;
            } else {
                if (matching.containsValue(tc)) return false;
                matching.put(sc, tc);
            }
        }

        return true;
    }
}
