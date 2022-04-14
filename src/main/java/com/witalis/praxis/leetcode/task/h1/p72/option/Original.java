package com.witalis.praxis.leetcode.task.h1.p72.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 72
 * Name: Edit Distance
 * URL: <a href="https://leetcode.com/problems/edit-distance/">Edit Distance</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String word1;
    private String word2;

    public Integer process() {
        return minDistance(word1, word2);
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        if (word1.length() == 0 || word2.length() == 0) return Math.abs(word1.length() - word2.length());
        if (word1.contains(word2) || word2.contains(word1)) return Math.abs(word1.length() - word2.length());

        return recursiveDistance(word1, word2, word1.length(), word2.length());
    }

    private int recursiveDistance(String word1, String word2, int w1, int w2) {
        if (w1 == 0) return w2;
        if (w2 == 0) return w1;

        if (word1.charAt(w1 - 1) == word2.charAt(w2 - 1)) {
            return recursiveDistance(word1, word2, w1 - 1, w2 - 1);
        } else {
            int opInsert = recursiveDistance(word1, word2, w1, w2 - 1);
            int opUpdate = recursiveDistance(word1, word2, w1 - 1, w2 - 1);
            int opRemove = recursiveDistance(word1, word2, w1 - 1, w2);

            return Math.min(opInsert, Math.min(opUpdate, opRemove)) + 1;
        }
    }
}
