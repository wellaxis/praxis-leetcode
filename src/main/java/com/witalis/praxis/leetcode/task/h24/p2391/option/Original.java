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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] garbage;
    private int[] travel;

    public Integer process() {
        return garbageCollection(garbage, travel);
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        if (garbage == null || travel == null) return 0;

        int minutes = 0;
        int time = 0;

        int[] indices = new int[3];
        Arrays.fill(indices, -1);

        minutes += garbage[0].length();
        for (int i = 1; i < garbage.length; i++) {
            minutes += garbage[i].length();

            if (garbage[i].contains("M")) {
                indices[0] = i - 1;
            }
            if (garbage[i].contains("P")) {
                indices[1] = i - 1;
            }
            if (garbage[i].contains("G")) {
                indices[2] = i - 1;
            }
        }

        for (int i = 0; i < travel.length; i++) {
            time += travel[i];

            for (int j = 0; j < 3; j++) {
                if (indices[j] == i) {
                    minutes += time;
                }
            }
        }

        return minutes;
    }
}
