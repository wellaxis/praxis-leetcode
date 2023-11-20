package com.witalis.praxis.leetcode.task.h24.p2391.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2391
 * Name: Minimum Amount of Time to Collect Garbage
 * URL: <a href="https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/">Minimum Amount of Time to Collect Garbage</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] garbage;
    private int[] travel;

    public Integer process() {
        return garbageCollection(garbage, travel);
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        if (garbage == null || travel == null) return 0;

        final String[] types = new String[] {"M", "P", "G"};
        final int n = garbage.length;

        final int[] indices = new int[3];
        Arrays.fill(indices, -1);

        int minutes = garbage[0].length();
        for (int i = 1; i < n; i++) {
            minutes += garbage[i].length();

            for (int j = 0; j < 3; j++)
                if (garbage[i].contains(types[j]))
                    indices[j] = i - 1;
        }

        int time = 0;
        for (int i = 0; i < n - 1; i++) {
            time += travel[i];

            for (int j = 0; j < 3; j++)
                if (indices[j] == i)
                    minutes += time;
        }

        return minutes;
    }
}
