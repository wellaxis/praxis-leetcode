package com.witalis.praxis.leetcode.task.h10.p917.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 917
 * Name: Reverse Only Letters
 * URL: <a href="https://leetcode.com/problems/reverse-only-letters/">Reverse Only Letters</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return reverseOnlyLetters(string);
    }

    public String reverseOnlyLetters(String s) {
        if (s == null || s.isEmpty()) return s;

        char[] letters = s.toCharArray();
        int n = letters.length;

        int l = 0;
        int r = n - 1;
        while (l < r) {
            while (l < n && !Character.isLetter(letters[l])) l++;
            while (r >= 0 && !Character.isLetter(letters[r])) r--;

            if (l >= r) break;

            char tmp = letters[l];
            letters[l] = letters[r];
            letters[r] = tmp;

            l++;
            r--;
        }

        return new String(letters);
    }
}
