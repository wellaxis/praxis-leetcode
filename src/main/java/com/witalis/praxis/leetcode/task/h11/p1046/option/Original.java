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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] stones;

    public Integer process() {
        return lastStoneWeight(stones);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;

        final Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) queue.offer(stone);

        while (queue.size() > 1) {
            final int max1 = queue.poll();
            final int max2 = queue.poll();

            if (max1 != max2) queue.offer(Math.abs(max1 - max2));
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }
}
