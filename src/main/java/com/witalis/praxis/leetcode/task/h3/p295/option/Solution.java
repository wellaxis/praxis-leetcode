package com.witalis.praxis.leetcode.task.h3.p295.option;

import com.witalis.praxis.leetcode.task.h3.p295.content.IMedianFinder;
import com.witalis.praxis.leetcode.task.h3.p295.content.MedianHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 295
 * Name: Find Median from Data Stream
 * URL: <a href="https://leetcode.com/problems/find-median-from-data-stream/">Find Median from Data Stream</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MedianFinder implements IMedianFinder {
        private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        private Queue<Integer> minHeap = new PriorityQueue<>();

        public MedianFinder() {
            super();
        }

        @Override
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek())
                maxHeap.offer(num);
            else
                minHeap.offer(num);

            // balance two heaps: |maxHeap| >= |minHeap| and |maxHeap| - |minHeap| <= 1
            if (maxHeap.size() < minHeap.size())
                maxHeap.offer(minHeap.poll());
            else if (maxHeap.size() - minHeap.size() > 1)
                minHeap.offer(maxHeap.poll());
        }

        @Override
        public double findMedian() {
            if (maxHeap.size() == minHeap.size())
                return (maxHeap.peek() + minHeap.peek()) / 2.0;

            return maxHeap.peek();
        }
    }

    public List<String> process() {
        return MedianHandler.process(operations, new MedianFinder());
    }
}
