package com.witalis.praxis.leetcode.task.h8.p703.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 703
 * Name: Kth Largest Element in a Stream
 * URL: <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">Kth Largest Element in a Stream</a>
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

    public int[] process() {
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

    public int[] kthLargestScenario(KthLargest kthLargest, int[] extra) {
        if (kthLargest == null || extra == null) return new int[0];

        int[] result = new int[extra.length];
        for (int i = 0; i < extra.length; i++) {
            result[i] = kthLargest.add(extra[i]);
        }

        return result;
    }
}
