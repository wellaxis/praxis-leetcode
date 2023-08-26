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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] pairs;

    public Integer process() {
        return findLongestChain(pairs);
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;

        Comparator<int[]> minByTail = Comparator.comparingInt(arr -> arr[1]);
        Comparator<int[]> minByHead = Comparator.comparingInt(arr -> arr[0]);

        Arrays.sort(pairs, minByTail.thenComparing(minByHead));

        int chain = 0;
        int edge = Integer.MIN_VALUE;
        for (int[] pair : pairs)
            if (pair[0] > edge) {
                chain++;
                edge = Math.max(edge, pair[1]);
            }

        return chain;
    }
}
