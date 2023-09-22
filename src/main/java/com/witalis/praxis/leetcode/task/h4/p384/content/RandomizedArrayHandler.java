package com.witalis.praxis.leetcode.task.h4.p384.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc: Randomized array operations handler
 * User: Wellaxis
 * Date: 09/22/2023
 */
@Slf4j
public final class RandomizedArrayHandler {

    private RandomizedArrayHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, int[]>> operations,
        RandomizableArray randomizableArray
    ) {
        List<String> results = new ArrayList<>();
        RandomizableArray randomizedArray = null;

        for (AbstractMap.SimpleEntry<String, int[]> operation: operations) {
            var name = operation.getKey();
            switch (name) {
                case "Solution" -> {
                    assert randomizedArray == null;
                    randomizedArray = randomizableArray;
                    results.add(null);
                }
                case "reset" -> {
                    assert randomizedArray != null;
                    var array = randomizedArray.reset();
                    results.add(array == null ? "null" : Arrays.toString(array));
                }
                case "shuffle" -> {
                    assert randomizedArray != null;
                    var array = randomizedArray.shuffle();
                    results.add(array == null ? "null" : Arrays.toString(array));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
