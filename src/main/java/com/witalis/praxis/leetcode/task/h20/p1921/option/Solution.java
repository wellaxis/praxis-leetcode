package com.witalis.praxis.leetcode.task.h20.p1921.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1921
 * Name: Eliminate Maximum Number of Monsters
 * URL: <a href="https://leetcode.com/problems/eliminate-maximum-number-of-monsters/">Eliminate Maximum Number of Monsters</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] distances;
    private int[] speeds;

    public Integer process() {
        return eliminateMaximum(distances, speeds);
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        final int n = dist.length;
        int[] arrivalTime = new int[n];

        for (int i = 0; i < n; ++i)
            arrivalTime[i] = (dist[i] - 1) / speed[i];

        Arrays.sort(arrivalTime);

        for (int i = 0; i < n; ++i)
            if (i > arrivalTime[i])
                return i;

        return n;
    }
}
