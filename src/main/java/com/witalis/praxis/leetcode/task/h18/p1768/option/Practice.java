package com.witalis.praxis.leetcode.task.h18.p1768.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1768
 * Name: Merge Strings Alternately
 * URL: <a href="https://leetcode.com/problems/merge-strings-alternately/">Merge Strings Alternately</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String word1;
    private String word2;

    public String process() {
        return mergeAlternately(word1, word2);
    }

    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word2 == null) return "";

        final StringBuilder builder = new StringBuilder(word1);

        final int n1 = word1.length();
        final int n2 = word2.length();

        int i1 = 1;
        int i2 = 0;
        while (i2 < n2 && i1 < n1 * 2) {
            builder.insert(i1, word2.charAt(i2++));
            i1 += 2;
        }
        if (i2 < n2)
            builder.append(word2.substring(i2));

        return builder.toString();
    }
}
