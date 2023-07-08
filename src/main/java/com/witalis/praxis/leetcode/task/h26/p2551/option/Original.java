package com.witalis.praxis.leetcode.task.h26.p2551.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 2551
 * Name: Put Marbles in Bags
 * URL: <a href="https://leetcode.com/problems/put-marbles-in-bags/">Put Marbles in Bags</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] weights;
    private int bags;

    public Long process() {
        return putMarbles(weights, bags);
    }

    public long putMarbles(int[] weights, int k) {
        if (weights == null || k <= 0) return 0L;

        final int n = weights.length;

        final Queue<Integer> minQueue = new PriorityQueue<>(Comparator.reverseOrder());
        final Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < n - 1; i++) {
            minQueue.offer(weights[i] + weights[i + 1]);
            maxQueue.offer(weights[i] + weights[i + 1]);
            if (minQueue.size() > k - 1) {
                minQueue.poll();
                maxQueue.poll();
            }
        }

        long minCost = 0L;
        long maxCost = 0L;
        while (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
            minCost += minQueue.poll();
            maxCost += maxQueue.poll();
        }

        return maxCost - minCost;
    }
}
