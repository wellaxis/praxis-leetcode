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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] distances;
    private int[] speeds;

    public Integer process() {
        return eliminateMaximum(distances, speeds);
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        if (dist == null || speed == null || dist.length != speed.length) return 0;

        final int n = dist.length;

        double[] times = new double[n];
        for (int i = 0; i < n; i++)
            times[i] = (double) dist[i] / speed[i];

        Arrays.sort(times);

        int count = 0;
        int t = 0;
        for (double time : times) {
            if (time <= t) break;

            count++;
            t++;
        }

        return count;
    }
}
