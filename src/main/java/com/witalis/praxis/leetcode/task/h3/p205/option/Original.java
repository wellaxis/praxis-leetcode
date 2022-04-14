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
 * URL: <a href="https://leetcode.com/problems/isomorphic-strings/">Isomorphic Strings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String source;
    private String target;

    public Boolean process() {
        return isIsomorphic(source, target);
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Character> matching = new HashMap<>();

        int index = 0;
        while (index < s.length()) {
            char sc = s.charAt(index);
            char tc = t.charAt(index);

            if (matching.containsKey(sc)) {
                if (matching.get(sc) != tc) return false;
            } else {
                if (matching.containsValue(tc)) return false;
                matching.put(sc, tc);
            }
            index++;
        }

        return true;
    }
}
