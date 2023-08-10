package com.witalis.praxis.leetcode.task.h4.p398.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Random pick operations handler
 * User: Wellaxis
 * Date: 08/10/2023
 */
@Slf4j
public final class RandomPickHandler {

    private RandomPickHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, int[]>> operations,
        RandomPick randomPick
    ) {
        List<Integer> results = new ArrayList<>();
        RandomPick randomizedPick = null;

        for (AbstractMap.SimpleEntry<String, int[]> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "Solution" -> {
                    assert randomizedPick == null;
                    randomizedPick = randomPick;
                    results.add(null);
                }
                case "pick" -> {
                    assert randomizedPick != null;
                    var random = randomizedPick.pick(value[0]);
                    results.add(random);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
