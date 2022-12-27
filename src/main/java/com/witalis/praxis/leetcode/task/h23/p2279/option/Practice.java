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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] capacity;
    private int[] rocks;
    private int additionalRocks;

    public Integer process() {
        return maximumBags(capacity, rocks, additionalRocks);
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        if (capacity == null || rocks == null || additionalRocks <= 0) return 0;

        for (int i = 0; i < capacity.length; i++)
            capacity[i] -= rocks[i];

        Arrays.sort(capacity);

        int bags = 0;
        for (int additionalRock : capacity) {
            if (additionalRocks == 0) return bags;

            if (additionalRocks >= additionalRock) {
                additionalRocks -= additionalRock;
                bags++;
            }
        }

        return bags;
    }
}
