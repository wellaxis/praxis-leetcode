package com.witalis.praxis.leetcode.task.h24.p2336.option;

import com.witalis.praxis.leetcode.task.h24.p2336.content.ISmallestInfiniteSet;
import com.witalis.praxis.leetcode.task.h24.p2336.content.SmallestInfiniteSetHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2336
 * Name: Smallest Number in Infinite Set
 * URL: <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/">Smallest Number in Infinite Set</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class SmallestInfiniteSet implements ISmallestInfiniteSet {
        private final Queue<Integer> queue;
        private int current;

        public SmallestInfiniteSet() {
            this.queue = new PriorityQueue<>(Comparator.naturalOrder());
            this.current = 1;
        }

        @Override
        public int popSmallest() {
            return queue.isEmpty() ? current++ : queue.poll();
        }

        @Override
        public void addBack(int num) {
            if (num < current && !queue.contains(num)) queue.offer(num);
        }
    }

    public List<Integer> process() {
        return SmallestInfiniteSetHandler.process(operations, new SmallestInfiniteSet());
    }
}
