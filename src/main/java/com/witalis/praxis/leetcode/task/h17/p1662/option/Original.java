package com.witalis.praxis.leetcode.task.h17.p1662.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1662
 * Name: Check If Two String Arrays are Equivalent
 * URL: <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/">Check If Two String Arrays are Equivalent</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] word1;
    private String[] word2;

    public Boolean process() {
        return arrayStringsAreEqual(word1, word2);
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null) return false;
        if (word1.length == 0 && word2.length == 0) return true;

        String w1 = buildString(word1);
        String w2 = buildString(word2);

        return w1.equals(w2);
    }

    private static String buildString(String[] tokens) {
        StringBuilder builder = new StringBuilder();
        for (String token : tokens)
            builder.append(token);
        return builder.toString();
    }
}
