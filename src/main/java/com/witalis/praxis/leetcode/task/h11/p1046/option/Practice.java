package com.witalis.praxis.leetcode.task.h11.p1046.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1046
 * Name: Last Stone Weight
 * URL: <a href="https://leetcode.com/problems/last-stone-weight/">Last Stone Weight</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] stones;

    public Integer process() {
        return lastStoneWeight(stones);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;

        final Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (final int stone : stones) queue.offer(stone);

        while (queue.size() > 1) {
            final int diff = Math.abs(queue.poll() - queue.poll());

            if (diff > 0) queue.offer(diff);
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }
}
