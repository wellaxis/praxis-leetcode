package com.witalis.praxis.leetcode.task.h11.p1001.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1001
 * Name: Grid Illumination
 * URL: <a href="https://leetcode.com/problems/grid-illumination/">Grid Illumination</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int size;
    private int[][] lamps;
    private int[][] queries;

    public int[] process() {
        return gridIllumination(size, lamps, queries);
    }

    public static final int[][] DIRECTION = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}, {0, 0}};

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] res = new int[queries.length];

        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> d1 = new HashMap<>();
        Map<Integer, Integer> d2 = new HashMap<>();
        Map<Integer, Boolean> cellNo = new HashMap<>();

        for (int[] lamp : lamps) {
            int r = lamp[0];
            int c = lamp[1];

            if (!cellNo.containsKey(N * r + c)) {
                row.put(r, row.getOrDefault(r, 0) + 1);
                col.put(c, col.getOrDefault(c, 0) + 1);
                d1.put(r - c, d1.getOrDefault(r - c, 0) + 1);
                d2.put(r + c, d2.getOrDefault(r + c, 0) + 1);
                cellNo.put(N * r + c, true);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];

            res[i] = (row.getOrDefault(r, 0) > 0 ||
                col.getOrDefault(c, 0) > 0 ||
                d1.getOrDefault(r - c, 0) > 0 ||
                d2.getOrDefault(r + c, 0) > 0) ? 1 : 0;

            // switch off the lamps, if any
            for (int[] d : DIRECTION) {
                int r1 = r + d[0];
                int c1 = c + d[1];

                if (r1 >= 0 && r1 < N && c1 >= 0 && c1 < N) {
                    if (cellNo.containsKey(N * r1 + c1) && cellNo.get(N * r1 + c1)) {

                        // the lamp is on, turn it off, so decrement the count of the lamps
                        row.put(r1, row.getOrDefault(r1, 1) - 1);
                        col.put(c1, col.getOrDefault(c1, 1) - 1);
                        d1.put(r1 - c1, d1.getOrDefault(r1 - c1, 1) - 1);
                        d2.put(r1 + c1, d2.getOrDefault(r1 + c1, 1) - 1);
                        cellNo.put(N * r1 + c1, false);
                    }
                }
            }
        }
        return res;
    }
}
