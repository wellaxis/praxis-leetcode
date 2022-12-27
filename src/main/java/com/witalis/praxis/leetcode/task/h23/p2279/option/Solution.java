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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] capacity;
    private int[] rocks;
    private int additionalRocks;

    public Integer process() {
        return maximumBags(capacity, rocks, additionalRocks);
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        long total = 0;
        int length = capacity.length;

        for (int i = 0; i < length; i++) {
            capacity[i] -= rocks[i];
            total += capacity[i];
        }

        if (total > additionalRocks) {
            Arrays.sort(capacity);
            for (int i = 0; i < length; i++) {
                if (additionalRocks < capacity[i]) {
                    return i;
                }
                additionalRocks -= capacity[i];
            }
        }

        return length;
    }
}
