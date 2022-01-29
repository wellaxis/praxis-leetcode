package com.witalis.praxis.leetcode.task.h8.p703.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ID: 703
 * Name: Kth Largest Element in a Stream
 * URL: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int k;
    private int[] numbers;
    private int[] extra;

    public Integer process() {
        KthLargest kthLargest = new KthLargest(k, numbers);
        return kthLargestScenario(kthLargest, extra);
    }

    class KthLargest {
        private final int k;
        private final PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            if (k > nums.length) {
                throw new IllegalArgumentException("Lack of elements in array for Kth largest search");
            }

            this.k = k;
            this.queue = new PriorityQueue<>(Arrays.stream(nums).boxed().toList());
        }

        public int add(int val) {
            queue.offer(val);
            while (queue.size() > k) queue.poll();
            return Optional.ofNullable(queue.peek()).orElseThrow(
                () -> new IllegalStateException("Unexpected result has been detected")
            );
        }
    }

    public int kthLargestScenario(KthLargest kthLargest, int[] extra) {
        if (kthLargest == null || extra == null) return 0;

        AtomicInteger kth = new AtomicInteger();
        for (int element : extra) {
            var add = kthLargest.add(element);
            kth.set(add);
        }

        return kth.get();
    }
}
