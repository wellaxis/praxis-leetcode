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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] costs;
    private int workers;
    private int candidates;

    public Long process() {
        return totalCost(costs, workers, candidates);
    }

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

        final Comparator<int[]> byMinValue = Comparator.comparingInt(p -> p[0]);
        final Comparator<int[]> byMinIndex = Comparator.comparingInt(p -> p[1]);
        final Queue<int[]> queue = new PriorityQueue<>(byMinValue.thenComparing(byMinIndex));

        for (int l = 0; l < candidates; l++)
            queue.offer(new int[] {costs[l], -1});
        for (int r = n - 1; r > n - 1 - candidates; r--)
            queue.offer(new int[] {costs[r], 1});

        int left = candidates;
        int right = n - 1 - candidates;
        while (k-- > 0) {
            final int[] worker = queue.poll();

            cost += worker[0];
            if (left <= right) {
                if (Integer.signum(worker[1]) < 0) {
                    queue.offer(new int[] {costs[left], -1});
                    left++;
                } else {
                    queue.offer(new int[] {costs[right], 1});
                    right--;
                }
            }
        }

        return cost;
    }
}
