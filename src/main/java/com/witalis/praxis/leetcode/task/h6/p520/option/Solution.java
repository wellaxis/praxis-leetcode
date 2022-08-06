package com.witalis.praxis.leetcode.task.h6.p520.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 520
 * Name: Detect Capital
 * URL: <a href="https://leetcode.com/problems/detect-capital/">Detect Capital</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String word;

    public Boolean process() {
        return detectCapitalUse(word);
    }

    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }

        // all capital
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < n; i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean detectCapitalUseRegex(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}
