package com.witalis.praxis.leetcode.task.h4.p344.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 344
 * Name: Reverse String
 * URL: <a href="https://leetcode.com/problems/reverse-string/">Reverse String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private char[] characters;

    public String process() {
        reverseString(characters);
        return String.valueOf(characters);
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        char buffer;
        for (int i = 0; i < s.length / 2; i++) {
            buffer = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = buffer;
        }
    }
}
