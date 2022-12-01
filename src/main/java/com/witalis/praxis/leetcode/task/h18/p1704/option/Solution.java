package com.witalis.praxis.leetcode.task.h18.p1704.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1704
 * Name: Determine if String Halves Are Alike
 * URL: <a href="https://leetcode.com/problems/determine-if-string-halves-are-alike/">Determine if String Halves Are Alike</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Boolean process() {
        return halvesAreAlike(string);
    }

    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();

        int len = s.length();
        len /= 2;

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < len; i++) {
            cnt1 += isVowel(s.charAt(i));
            cnt2 += isVowel(s.charAt(i + len));
        }

        return cnt1 == cnt2;
    }

    private int isVowel(char c) {
        return "aoeiu".indexOf(c) != -1 ? 1 : 0;
    }
}
