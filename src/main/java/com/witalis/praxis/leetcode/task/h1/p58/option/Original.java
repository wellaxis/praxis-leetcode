package com.witalis.praxis.leetcode.task.h1.p58.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 58
 * Name: Length of Last Word
 * URL: <a href="https://leetcode.com/problems/length-of-last-word/">Length of Last Word</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return lengthOfLastWord(string);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.isBlank()) return 0;

        var source = s.trim();
        if (source.indexOf(' ') < 0) return source.length();

        var letters = source.toCharArray();
        for (int i = letters.length - 1; i > 0; i--) {
            if (letters[i] == ' ') return letters.length - i - 1;
        }
        return 0;
    }
}
