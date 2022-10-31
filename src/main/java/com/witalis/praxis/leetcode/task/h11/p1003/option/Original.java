package com.witalis.praxis.leetcode.task.h11.p1003.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1003
 * Name: Check If Word Is Valid After Substitutions
 * URL: <a href="https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/">Check If Word Is Valid After Substitutions</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Boolean process() {
        string = "abcabcababcc";
        return isValid(string);
    }

    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;

        int len = Integer.MAX_VALUE;
        while (!s.isEmpty() && s.length() < len) {
            len = s.length();
            s = s.replace("abc", "");
        }

        return s.isEmpty();
    }
}
