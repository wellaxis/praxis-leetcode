package com.witalis.praxis.leetcode.task.h4.p380.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Randomized set operations handler
 * User: Wellaxis
 * Date: 11/29/2022
 */
@Slf4j
public final class RandomizedSetHandler {

    private RandomizedSetHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        RandomizableSet<Integer> randomizableSet
    ) {
        List<String> results = new ArrayList<>();
        RandomizableSet<Integer> randomizedSet = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "RandomizedSet" -> {
                    assert randomizedSet == null;
                    randomizedSet = randomizableSet;
                    results.add(null);
                }
                case "insert" -> {
                    assert randomizedSet != null;
                    randomizedSet.insert(value);
                    results.add(String.format("-> %d", value));
                }
                case "remove" -> {
                    assert randomizedSet != null;
                    randomizedSet.remove(value);
                    results.add(String.format("<- %d", value));
                }
                case "getRandom" -> {
                    assert randomizedSet != null;
                    var random = randomizedSet.getRandom();
                    results.add(String.valueOf(random));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
