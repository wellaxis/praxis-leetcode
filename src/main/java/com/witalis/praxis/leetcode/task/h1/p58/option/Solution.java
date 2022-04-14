package com.witalis.praxis.leetcode.task.h1.p58.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 58
 * Name: Length of Last Word
 * URL: <a href="https://leetcode.com/problems/length-of-last-word/">Length of Last Word</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return lengthOfLastWord(string);
    }

    public int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                len++;
            }
        }
        return len;
    }
}
