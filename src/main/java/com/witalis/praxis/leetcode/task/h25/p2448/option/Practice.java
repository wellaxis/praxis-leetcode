package com.witalis.praxis.leetcode.task.h25.p2448.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 2448
 * Name: Minimum Cost to Make Array Equal
 * URL: <a href="https://leetcode.com/problems/minimum-cost-to-make-array-equal/">Minimum Cost to Make Array Equal</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int[] costs;

    public Long process() {
        return minCost(numbers, costs);
    }

    record Pair(int value, int price) {}

    public long minCost(int[] nums, int[] cost) {
        if (nums == null || cost == null) return 0L;

        final int n = nums.length;
        final Pair[] pairs = new Pair[n];

        long sum = 0L;
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], cost[i]);
            sum += cost[i];
        }

        Arrays.sort(pairs, Comparator.comparingInt(p -> p.value));

        long median = 0L;
        long current = 0L;
        int i = 0;
        while (i < n && current < (sum + 1) / 2) {
            current += pairs[i].price;
            median = pairs[i].value;
            i++;
        }

        long minCost = 0L;
        for (final Pair pair : pairs)
            minCost += Math.abs(pair.value - median) * (pair.price);

        return minCost;
    }
}
