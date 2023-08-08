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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MedianFinder implements IMedianFinder {
        private final Queue<Integer> minHeap;
        private final Queue<Integer> maxHeap;

        public MedianFinder() {
            this.minHeap = new PriorityQueue<>(Comparator.naturalOrder());
            this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        @Override
        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());
        }

        @Override
        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();

            return (minHeap.peek() + maxHeap.peek()) / 2D;
        }
    }

    public List<String> process() {
        return MedianHandler.process(operations, new MedianFinder());
    }
}
