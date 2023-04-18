package com.witalis.praxis.leetcode.task.h18.p1768.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1768
 * Name: Merge Strings Alternately
 * URL: <a href="https://leetcode.com/problems/merge-strings-alternately/">Merge Strings Alternately</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String word1;
    private String word2;

    public String process() {
        return mergeAlternately(word1, word2);
    }

    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.isEmpty() || word2 == null || word2.isEmpty()) return "";

        final int n1 = word1.length();
        final int n2 = word2.length();
        final StringBuilder builder = new StringBuilder();

        int i1 = 0;
        int i2 = 0;
        boolean direct = true;
        while (i1 < n1 || i2 < n2) {
            if (i1 >= n1) direct = false;
            if (i2 >= n2) direct = true;

            if (direct) {
                builder.append(word1.charAt(i1++));
            } else {
                builder.append(word2.charAt(i2++));
            }
            direct = !direct;
        }

        return builder.toString();
    }
}
