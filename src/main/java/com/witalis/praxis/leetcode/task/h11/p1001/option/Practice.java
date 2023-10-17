package com.witalis.praxis.leetcode.task.h11.p1001.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1001
 * Name: Grid Illumination
 * URL: <a href="https://leetcode.com/problems/grid-illumination/">Grid Illumination</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int size;
    private int[][] lamps;
    private int[][] queries;

    public int[] process() {
        return gridIllumination(size, lamps, queries);
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        if (n <= 0 || lamps == null || queries == null) return new int[0];

        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        Map<Integer, Integer> mainDiagonals = new HashMap<>();
        Map<Integer, Integer> antiDiagonals = new HashMap<>();

        Set<List<Integer>> turnedOnLamps = new HashSet<>();

        for (int[] lamp : lamps) {
            if (!turnedOnLamps.add(new ArrayList<>(List.of(lamp[0], lamp[1])))) continue;

            rows.put(lamp[0], rows.getOrDefault(lamp[0], 0) + 1);
            cols.put(lamp[1], cols.getOrDefault(lamp[1], 0) + 1);
            mainDiagonals.put(lamp[0] - lamp[1] + n - 1, mainDiagonals.getOrDefault(lamp[0] - lamp[1] + n - 1, 0) + 1);
            antiDiagonals.put(lamp[0] + lamp[1], antiDiagonals.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        }

        final int len = queries.length;
        int[] ans = new int[len];

        int i = 0;
        for (int[] query : queries) {
            int row = query[0];
            int col = query[1];
            int sum = rows.getOrDefault(row, 0) +
                cols.getOrDefault(col, 0) +
                mainDiagonals.getOrDefault(row - col + n - 1, 0) +
                antiDiagonals.getOrDefault(row + col, 0);

            ans[i++] = sum > 0 ? 1 : 0;

            for (int dRow = -1; dRow <= 1; ++dRow) {
                for (int dCol = -1; dCol <= 1; ++dCol) {
                    int r = row + dRow;
                    int c = col + dCol;

                    if (r < 0 || c < 0 || r >= n || c >= n) continue;

                    List<Integer> lampPos = new ArrayList<>(List.of(r, c));
                    if (turnedOnLamps.contains(lampPos)) {
                        turnedOnLamps.remove(lampPos);

                        rows.put(r, rows.getOrDefault(r, 0) - 1);
                        cols.put(c, cols.getOrDefault(c, 0) - 1);
                        mainDiagonals.put(r - c + n - 1, mainDiagonals.getOrDefault(r - c + n - 1, 0) - 1);
                        antiDiagonals.put(r + c, antiDiagonals.getOrDefault(r + c, 0) - 1);
                    }
                }
            }
        }

        return ans;
    }
}
