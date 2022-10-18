package com.witalis.praxis.leetcode.task.h4.p307.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Numeric array operations handler
 * User: Wellaxis
 * Date: 10/18/2022
 */
@Slf4j
public final class NumericArrayHandler {

    private NumericArrayHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, int[]>> operations,
        NumericArray numericArray
    ) {
        List<Integer> results = new ArrayList<>();

        for (AbstractMap.SimpleEntry<String, int[]> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "update" -> {
                    numericArray.update(value[0], value[1]);
                    results.add(null);
                }
                case "sumRange" -> {
                    int sum = numericArray.sumRange(value[0], value[1]);
                    results.add(sum);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
