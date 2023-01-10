package com.witalis.praxis.leetcode.task.h22.p2103.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2103
 * Name: Rings and Rods
 * URL: <a href="https://leetcode.com/problems/rings-and-rods/">Rings and Rods</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String rings;

    public Integer process() {
        return countPoints(rings);
    }

    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    public int countPoints(String rings) {
        if (rings == null || rings.isEmpty()) return 0;

        final int[][] rods = new int[10][3];

        final int len = rings.length() / 2;
        final char[] letters = rings.toCharArray();
        for (int i = 0; i < len; i++) {
            final int rod = letters[(2 * i) + 1] - '0';
            final char color = letters[2 * i];
            switch (color) {
                case 'R' -> rods[rod][RED]++;
                case 'G' -> rods[rod][GREEN]++;
                case 'B' -> rods[rod][BLUE]++;
            }
        }

        int count = 0;
        for (final int[] rod : rods)
            if (rod[0] > 0 && rod[1] > 0 && rod[2] > 0)
                count++;

        return count;
    }
}
