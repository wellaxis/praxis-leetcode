package com.witalis.praxis.leetcode.task.h1.p58.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 58
 * Name: Length of Last Word
 * URL: <a href="https://leetcode.com/problems/length-of-last-word/">Length of Last Word</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return lengthOfLastWord(string);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.isBlank()) return 0;

        s = s.trim();
        if (s.indexOf(' ') < 0) return s.length();

        return s.substring(s.lastIndexOf(' ') + 1).length();
    }
}
