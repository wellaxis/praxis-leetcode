package com.witalis.praxis.leetcode.task.h7.p646.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 646
 * Name: Maximum Length of Pair Chain
 * URL: <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">Maximum Length of Pair Chain</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] pairs;

    public Integer process() {
        return findLongestChain(pairs);
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs == null) return 0;

        Comparator<int[]> minByTail = Comparator.comparingInt(arr -> arr[1]);
        Comparator<int[]> minByHead = Comparator.comparingInt(arr -> arr[0]);

        Arrays.sort(pairs, minByTail.thenComparing(minByHead));

        int n = pairs.length;

        int chain = 0;
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int start = pairs[i][0];
            int end = pairs[i][1];

            if (start > edge) {
                chain++;
                edge = Math.max(edge, end);
            }
        }

        return chain;
    }
}
