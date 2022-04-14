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

    public int[] process() {
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

    public int[] kthLargestScenario(KthLargest kthLargest, int[] extra) {
        if (kthLargest == null || extra == null) return new int[0];

        int[] result = new int[extra.length];
        for (int i = 0; i < extra.length; i++) {
            result[i] = kthLargest.add(extra[i]);
        }

        return result;
    }
}
