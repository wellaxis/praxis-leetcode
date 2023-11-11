package com.witalis.praxis.leetcode.task.h27.p2642.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Shortest graph path calculator handler
 * User: Wellaxis
 * Date: 11/11/2023
 */
@Slf4j
public final class ShortestGraphPathCalculatorHandler {

    private ShortestGraphPathCalculatorHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, Object>> operations,
        IShortestGraphPathCalculator shortestGraphPathCalculator
    ) {
        List<Integer> results = new ArrayList<>();

        IShortestGraphPathCalculator handlingShortestGraphPathCalculator = null;

        for (AbstractMap.SimpleEntry<String, Object> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "Graph" -> {
                    assert handlingShortestGraphPathCalculator == null;
                    handlingShortestGraphPathCalculator = shortestGraphPathCalculator;
                    results.add(null);
                }
                case "addEdge" -> {
                    assert handlingShortestGraphPathCalculator != null;
                    int[] array = (int[]) value;
                    handlingShortestGraphPathCalculator.addEdge(array);
                    results.add(null);
                }
                case "shortestPath" -> {
                    assert handlingShortestGraphPathCalculator != null;
                    int[] array = (int[]) value;
                    int path = handlingShortestGraphPathCalculator.shortestPath(array[0], array[1]);
                    results.add(path);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
