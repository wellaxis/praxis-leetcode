package com.witalis.praxis.leetcode.task.h25.p2462.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 2462
 * Name: Total Cost to Hire K Workers
 * URL: <a href="https://leetcode.com/problems/total-cost-to-hire-k-workers/">Total Cost to Hire K Workers</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] costs;
    private int workers;
    private int candidates;

    public Long process() {
        return totalCost(costs, workers, candidates);
    }

    record Pair (int value, int index) {}

    public long totalCost(int[] costs, int k, int candidates) {
        if (costs == null || k <= 0 || candidates <= 0) return 0L;

        final int n = costs.length;
        long cost = 0L;

        if (candidates * 2 >= n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++)
                cost += costs[i];

            return cost;
        }

        final Comparator<Pair> byMinValue = Comparator.comparingInt(p -> p.value);
        final Comparator<Pair> byMinIndex = Comparator.comparingInt(p -> p.index);
        final Queue<Pair> queue = new PriorityQueue<>(byMinValue.thenComparing(byMinIndex));

        for (int l = 0; l < candidates; l++)
            queue.offer(new Pair(costs[l], l));
        for (int r = n - 1; r > n - 1 - candidates; r--)
            queue.offer(new Pair(costs[r], r));

        int left = candidates;
        int right = n - 1 - candidates;
        while (k > 0) {
            final Pair pair = queue.poll();

            cost += pair.value;
            if (left <= right) {
                if (pair.index <= left) {
                    queue.offer(new Pair(costs[left], left++));
                } else {
                    queue.offer(new Pair(costs[right], right--));
                }
            }

            k--;
        }

        return cost;
    }
}
