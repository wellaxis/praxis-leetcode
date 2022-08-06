package com.witalis.praxis.leetcode.task.h6.p520.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 520
 * Name: Detect Capital
 * URL: <a href="https://leetcode.com/problems/detect-capital/">Detect Capital</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String word;

    public Boolean process() {
        return detectCapitalUse(word);
    }

    public boolean detectCapitalUse(String word) {
        if (word == null || word.isEmpty()) return false;
        if (word.length() == 1) return true;

        boolean capital1st = Character.isUpperCase(word.charAt(0));
        boolean capital2nd = Character.isUpperCase(word.charAt(1));
        for (int i = 1; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!capital1st && Character.isUpperCase(letter)) return false;
            if (capital1st && capital2nd && Character.isLowerCase(letter) && i > 1) return false;
            if (capital1st && !capital2nd && Character.isUpperCase(letter) && i > 1) return false;
        }

        return true;
    }
}
