package com.witalis.praxis.leetcode.task.h3.p295.option;

import com.witalis.praxis.leetcode.task.h3.p295.content.IMedianFinder;
import com.witalis.praxis.leetcode.task.h3.p295.content.MedianHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * ID: 295
 * Name: Find Median from Data Stream
 * URL: <a href="https://leetcode.com/problems/find-median-from-data-stream/">Find Median from Data Stream</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MedianFinder implements IMedianFinder {
        private final List<Integer> list;

        public MedianFinder() {
            this.list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            int size = list.size();

            DoubleStream stream = list.stream().mapToDouble(Double::valueOf).sorted();
            double median;
            if (size % 2 == 0) {
                median = stream.skip(size / 2 - 1L).limit(2).average().getAsDouble();
            } else {
                median = stream.skip(size / 2).findFirst().getAsDouble();
            }

            return median;
        }
    }

    public List<String> process() {
        return MedianHandler.process(operations, new MedianFinder());
    }
}
