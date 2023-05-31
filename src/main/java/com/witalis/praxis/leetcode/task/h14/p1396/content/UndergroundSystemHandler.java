package com.witalis.praxis.leetcode.task.h14.p1396.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Underground system operations handler
 * User: Wellaxis
 * Date: 05/31/2023
 */
@Slf4j
public final class UndergroundSystemHandler {

    private UndergroundSystemHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, Object[]>> operations,
        IUndergroundSystem undergroundSystem
    ) {
        List<String> results = new ArrayList<>();

        for (AbstractMap.SimpleEntry<String, Object[]> operation: operations) {
            var name = operation.getKey();
            var values = operation.getValue();
            switch (name) {
                case "UndergroundSystem" -> results.add("");
                case "checkIn" -> {
                    undergroundSystem.checkIn((Integer) values[0], (String) values[1], (Integer) values[2]);
                    results.add("");
                }
                case "checkOut" -> {
                    undergroundSystem.checkOut((Integer) values[0], (String) values[1], (Integer) values[2]);
                    results.add("");
                }
                case "getAverageTime" -> {
                    double time = undergroundSystem.getAverageTime((String) values[0], (String) values[1]);
                    results.add(String.valueOf(time));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
