package com.witalis.praxis.leetcode.task.h18.p1768.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1768
 * Name: Merge Strings Alternately
 * URL: <a href="https://leetcode.com/problems/merge-strings-alternately/">Merge Strings Alternately</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String word1;
    private String word2;

    public String process() {
        return mergeAlternately(word1, word2);
    }

    public String mergeAlternately(String word1, String word2) {
        final int n = Math.min(word1.length(), word2.length());
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        return sb.append(word1.substring(n)).append(word2.substring(n)).toString();
    }
}
