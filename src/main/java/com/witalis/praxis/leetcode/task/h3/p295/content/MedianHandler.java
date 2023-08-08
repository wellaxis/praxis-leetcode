package com.witalis.praxis.leetcode.task.h3.p295.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Median finder handler
 * User: Wellaxis
 * Date: 08.08.2023
 */
@Slf4j
public final class MedianHandler {

    private MedianHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        IMedianFinder medianFinder
    ) {
        List<String> results = new ArrayList<>();

        IMedianFinder finder = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "MedianFinder" -> {
                    assert finder == null;
                    finder = medianFinder;
                    results.add(null);
                }
                case "addNum" -> {
                    assert finder != null;
                    finder.addNum(value);
                    results.add('\u2193' + " " + value);
                }
                case "findMedian" -> {
                    assert finder != null;
                    double median = finder.findMedian();
                    results.add('\u2191' + " " + String.format("%.2f", median));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
