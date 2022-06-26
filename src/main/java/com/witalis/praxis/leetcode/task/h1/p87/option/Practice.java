package com.witalis.praxis.leetcode.task.h1.p87.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 87
 * Name: Scramble String
 * URL: <a href="https://leetcode.com/problems/scramble-string/">Scramble String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string1;
    private String string2;

    public Practice(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public Boolean process() {
        return isScramble(string1, string2);
    }

    private Map<String, Boolean> cache = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

        if (s1.equals(s2)) return true;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (!Arrays.equals(chars1, chars2)) return false;

        return recursiveScramble(s1, s2);
    }

    private boolean recursiveScramble(String s1, String s2) {
        String key = s1 + "|" + s2;
        if (cache.containsKey(key)) return cache.get(key);

        if (s1.equals(s2)) return true;
        if (s1.length() <= 1) return false;

        for (int i = 1; i < s1.length(); i++) {
            // direct
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                cache.put(key, true);
                return true;
            }
            // reverse
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) &&
                isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) {
                cache.put(key, true);
                return true;
            }
        }

        cache.put(key, false);
        return false;
    }
}
