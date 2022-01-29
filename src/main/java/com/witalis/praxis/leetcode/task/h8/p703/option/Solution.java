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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int k;
    private int[] numbers;
    private int[] extra;

    public Integer process() {
        KthLargest kthLargest = new KthLargest(k, numbers);
        return kthLargestScenario(kthLargest, extra);
    }

    class KthLargest {
        private static int k;
        private PriorityQueue<Integer> heap;

        public KthLargest(int k, int[] nums) {
            KthLargest.k = k;
            heap = new PriorityQueue<>();

            for (int num: nums) {
                heap.offer(num);
            }

            while (heap.size() > k) {
                heap.poll();
            }
        }

        public int add(int val) {
            heap.offer(val);
            if (heap.size() > k) {
                heap.poll();
            }

            return heap.peek();
        }
    }

    public int kthLargestScenario(KthLargest kthLargest, int[] extra) {
        if (kthLargest == null || extra == null) return 0;

        AtomicInteger kth = new AtomicInteger();
        Arrays.stream(extra).forEach(
            element -> kth.set(kthLargest.add(element))
        );

        return kth.get();
    }
}
