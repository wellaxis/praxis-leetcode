package com.witalis.praxis.leetcode.task.h23.p2201.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2201
 * Name: Count Artifacts That Can Be Extracted
 * URL: <a href="https://leetcode.com/problems/count-artifacts-that-can-be-extracted/">Count Artifacts That Can Be Extracted</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int dimension;
    private int[][] artifacts;
    private int[][] dig;

    public Integer process() {
        return digArtifacts(dimension, artifacts, dig);
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int count = 0;

        boolean[] set = new boolean[n * n];
        for (int[] d : dig)
            set[d[0] * n + d[1]] = true;
        for (int[] artifact : artifacts) {
            boolean all = true;
            for (int i = artifact[0]; i <= artifact[2]; i++)
                for (int j = artifact[1]; j <= artifact[3]; j++) {
                    if (!set[i * n + j]) {
                        all = false;
                        break;
                    }
                }
            if (all) count += 1;
        }

        return count;
    }
}
