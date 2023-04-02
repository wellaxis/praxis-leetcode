package com.witalis.praxis.leetcode.task.h24.p2300.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2300
 * Name: Successful Pairs of Spells and Potions
 * URL: <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/">Successful Pairs of Spells and Potions</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] spells;
    private int[] potions;
    private long success;

    public int[] process() {
        return successfulPairs(spells, potions, success);
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        if (spells == null || potions == null || success < 0) return new int[0];

        final int n = spells.length;
        final int m = potions.length;
        final int[] pairs = new int[n];

        Arrays.sort(potions);

        int left;
        int right;
        int mid;
        for (int i = 0; i < n; i++) {

            left = 0;
            right = m;
            while (left < right) {
                mid = left + (right - left) / 2;
                if ((long) spells[i] * potions[mid] < success) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            pairs[i] = m - left;
        }

        return pairs;
    }
}
