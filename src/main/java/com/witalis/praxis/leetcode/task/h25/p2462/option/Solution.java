package com.witalis.praxis.leetcode.task.h25.p2462.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 2462
 * Name: Total Cost to Hire K Workers
 * URL: <a href="https://leetcode.com/problems/total-cost-to-hire-k-workers/">Total Cost to Hire K Workers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] costs;
    private int workers;
    private int candidates;

    public Long process() {
        return totalCost(costs, workers, candidates);
    }

    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;

        if (2 * candidates > costs.length - k || costs.length == k) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                cost += costs[i];
            }
            return cost;
        }

        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();

        int l = 0;
        int r = costs.length - 1;
        for (int i = 0; i < candidates; i++) {
            left.add(costs[l++]);
            right.add(costs[r--]);
        }

        while (k-- > 0) {
            if (left.peek() <= right.peek()) {
                cost += left.poll();
                left.add(costs[l++]);
            } else {
                cost += right.poll();
                right.add(costs[r--]);
            }
        }

        return cost;
    }
}
