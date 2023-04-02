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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
        for (int i = 0; i < n; i++) {
            final int spell = spells[i];

            int l = 0;
            int r = m;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if ((long) spell * potions[mid] < success) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            pairs[i] = m - l;
        }

        return pairs;
    }
}
