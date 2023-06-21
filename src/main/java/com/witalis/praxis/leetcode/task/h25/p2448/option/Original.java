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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int[] costs;

    public Long process() {
        return minCost(numbers, costs);
    }

    record Pair(int value, int price) {}

    public long minCost(int[] nums, int[] cost) {
        if (nums == null || cost == null) return 0L;

        int n = nums.length;

        long sum = 0L;

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], cost[i]);
            sum += cost[i];
        }

        Arrays.sort(pairs, Comparator.comparingInt(p -> p.value));

        long median = 0;
        long current = 0;
        int i = 0;
        while (i < n && current < (sum + 1) / 2) {
            current += pairs[i].price();
            median = pairs[i].value;
            i++;
        }

        long minCost = 0;
        for (Pair pair : pairs)
            minCost += Math.abs(pair.value - median) * (pair.price);

        return minCost;
    }
}
