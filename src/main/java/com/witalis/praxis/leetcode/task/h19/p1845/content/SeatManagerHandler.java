package com.witalis.praxis.leetcode.task.h19.p1845.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Seat manager operations handler
 * User: Wellaxis
 * Date: 6/11/2023
 */
@Slf4j
public final class SeatManagerHandler {

    private SeatManagerHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        ISeatManager seatManager
    ) {
        List<String> results = new ArrayList<>();

        ISeatManager handlerSeatManager = null;
        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "SeatManager" -> {
                    assert handlerSeatManager == null;
                    handlerSeatManager = seatManager;
                    results.add("'" + value + "'");
                }
                case "reserve" -> {
                    assert handlerSeatManager != null;
                    int seatNumber = handlerSeatManager.reserve();
                    results.add("");
                }
                case "unreserve" -> {
                    assert handlerSeatManager != null;
                    handlerSeatManager.unreserve(value);
                    results.add(String.valueOf(value));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
