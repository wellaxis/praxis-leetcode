package com.witalis.praxis.leetcode.task.h6.p520.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 520
 * Name: Detect Capital
 * URL: <a href="https://leetcode.com/problems/detect-capital/">Detect Capital</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String word;

    public Boolean process() {
        return detectCapitalUse(word);
    }

    public boolean detectCapitalUse(String word) {
        if (word == null || word.isEmpty()) return false;
        if (word.length() == 1) return true;

        if (word.equals(word.toLowerCase())) return true;
        if (word.equals(word.toUpperCase())) return true;
        return Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase());
    }
}
