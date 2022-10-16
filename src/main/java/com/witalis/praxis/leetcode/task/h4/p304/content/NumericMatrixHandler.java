package com.witalis.praxis.leetcode.task.h4.p304.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Numeric matrix operations handler
 * User: Wellaxis
 * Date: 5/14/2022
 */
@Slf4j
public final class NumericMatrixHandler {

    private NumericMatrixHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, int[]>> operations,
        NumericMatrix numMatrix
    ) {
        List<Integer> results = new ArrayList<>();

        for (AbstractMap.SimpleEntry<String, int[]> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            if ("sumRegion".equals(name)) {
                int sum = numMatrix.sumRegion(value[0], value[1], value[2], value[3]);
                results.add(sum);
            } else {
                throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
