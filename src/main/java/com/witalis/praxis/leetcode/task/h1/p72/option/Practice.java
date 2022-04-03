package com.witalis.praxis.leetcode.task.h1.p72.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 72
 * Name: Edit Distance
 * URL: https://leetcode.com/problems/edit-distance/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String word1;
    private String word2;

    public Integer process() {
        return minDistance(word1, word2);
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;

        int w1 = word1.length();
        int w2 = word2.length();

        if (w1 == 0 || w2 == 0 || word1.contains(word2) || word2.contains(word1)) return Math.abs(w1 - w2);

        return recursiveDistance(word1, word2, word1.length(), word2.length(), new int[w1 + 1][w2 + 1]);
    }

    private int recursiveDistance(String word1, String word2, int w1, int w2, int[][] cache) {
        if (cache[w1][w2] > 0) return cache[w1][w2];

        if (w1 == 0) return w2;
        if (w2 == 0) return w1;

        int result;
        if (word1.charAt(w1 - 1) == word2.charAt(w2 - 1)) {
            result = recursiveDistance(word1, word2, w1 - 1, w2 - 1, cache);
        } else {
            int opInsert = recursiveDistance(word1, word2, w1, w2 - 1, cache);
            cache[w1][w2 - 1] = opInsert;
            int opUpdate = recursiveDistance(word1, word2, w1 - 1, w2 - 1, cache);
            cache[w1 - 1][w2 - 1] = opUpdate;
            int opRemove = recursiveDistance(word1, word2, w1 - 1, w2, cache);
            cache[w1 - 1][w2] = opRemove;

            result = Math.min(opInsert, Math.min(opUpdate, opRemove)) + 1;
        }
        cache[w1][w2] = result;
        return result;
    }
}
