package com.witalis.praxis.leetcode.task.h3.p215.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 215
 * Name: Kth Largest Element in an Array
 * URL: <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int index;

    public Integer process() {
        return findKthLargest(numbers, index);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (k > nums.length) throw new IllegalArgumentException("Incorrect index k");

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num: nums) queue.offer(num);
        for (; k > 1; k--) queue.poll();

        return queue.peek();
    }
}
