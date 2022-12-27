package com.witalis.praxis.leetcode.task.h23.p2279.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2279
 * Name: Maximum Bags With Full Capacity of Rocks
 * URL: <a href="https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/">Maximum Bags With Full Capacity of Rocks</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] capacity;
    private int[] rocks;
    private int additionalRocks;

    public Integer process() {
        return maximumBags(capacity, rocks, additionalRocks);
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        if (capacity == null || rocks == null || additionalRocks <= 0) return 0;

        int len = capacity.length;
        int[] diffs = new int[len];
        for (int i = 0; i < len; i++) {
            diffs[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diffs);

        int bags = 0;
        for (int diff : diffs) {
            if (additionalRocks == 0) break;

            if (additionalRocks >= diff) {
                additionalRocks -= diff;
                bags++;
            }
        }

        return bags;
    }
}
