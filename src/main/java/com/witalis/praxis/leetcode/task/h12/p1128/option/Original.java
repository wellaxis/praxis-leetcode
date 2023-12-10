package com.witalis.praxis.leetcode.task.h12.p1128.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1128
 * Name: Number of Equivalent Domino Pairs
 * URL: <a href="https://leetcode.com/problems/number-of-equivalent-domino-pairs/">Number of Equivalent Domino Pairs</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] dominoes;

    public Integer process() {
        return numEquivDominoPairs(dominoes);
    }

    static class DominoPairs {
        private final Map<String, Integer> pairs;

        public DominoPairs(int[][] dominoes) {
            this.pairs = storePairs(dominoes);
        }

        private static Map<String, Integer> storePairs(int[][] dominoes) {
            Map<String, Integer> pairs = new HashMap<>();
            for (int[] domino : dominoes) {
                final String key = getDominoKey(domino);

                pairs.put(key, pairs.getOrDefault(key, 0) + 1);
            }

            return pairs;
        }

        private static String getDominoKey(int[] domino) {
            final int the1st = domino[0];
            final int the2nd = domino[1];

            return Math.min(the1st, the2nd) + "-" + Math.max(the1st, the2nd);
        }

        private int countParis() {
            return pairs.values().stream().map(DominoPairs::numberPairs).mapToInt(Integer::intValue).sum();
        }

        // i[n] = i[n - 1] + i
        private static int numberPairs(int count) {
            if (count == 0 || count == 1) return 0;

            return numberPairs(count -1) + (count - 1);
        }
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        return (dominoes == null) ? 0 : new DominoPairs(dominoes).countParis();
    }
}
