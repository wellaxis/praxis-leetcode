package com.witalis.praxis.leetcode.task.h10.p917.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 917
 * Name: Reverse Only Letters
 * URL: <a href="https://leetcode.com/problems/reverse-only-letters/">Reverse Only Letters</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return reverseOnlyLetters(string);
    }

    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            while (i < j && !Character.isLetter(s.charAt(i)))
                ++i;
            while (i < j && !Character.isLetter(s.charAt(j)))
                --j;
            sb.setCharAt(i, s.charAt(j));
            sb.setCharAt(j, s.charAt(i));
        }

        return sb.toString();
    }
}
