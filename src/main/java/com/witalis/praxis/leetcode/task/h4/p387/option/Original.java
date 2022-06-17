package com.witalis.praxis.leetcode.task.h4.p387.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 387
 * Name: First Unique Character in a String
 * URL: <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">First Unique Character in a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return firstUniqChar(string);
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (s.indexOf(letters[i]) == s.lastIndexOf(letters[i])) return i;
        }

        return -1;
    }
}
