package com.witalis.praxis.leetcode.task.h10.p901.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Stock spanner set operations handler
 * User: Wellaxis
 * Date: 12/12/2022
 */
@Slf4j
public final class StockSpannerHandler {

    private StockSpannerHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        StockSpannable stockSpannable
    ) {
        List<Integer> results = new ArrayList<>();
        StockSpannable stockSpanner = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "StockSpanner" -> {
                    assert stockSpanner == null;
                    stockSpanner = stockSpannable;
                    results.add(null);
                }
                case "next" -> {
                    assert stockSpanner != null;
                    int span = stockSpanner.next(value);
                    results.add(span);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
