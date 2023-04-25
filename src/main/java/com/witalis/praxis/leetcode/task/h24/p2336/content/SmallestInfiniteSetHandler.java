package com.witalis.praxis.leetcode.task.h24.p2336.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Smallest infinite set operations handler
 * User: Wellaxis
 * Date: 25/04/2023
 */
@Slf4j
public final class SmallestInfiniteSetHandler {

    private SmallestInfiniteSetHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        ISmallestInfiniteSet smallestInfiniteSet
    ) {
        List<Integer> results = new ArrayList<>();

        ISmallestInfiniteSet handlingSmallestInfiniteSet = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "SmallestInfiniteSet" -> {
                    assert handlingSmallestInfiniteSet == null;
                    handlingSmallestInfiniteSet = smallestInfiniteSet;
                    results.add(null);
                }
                case "addBack" -> {
                    assert handlingSmallestInfiniteSet != null;
                    handlingSmallestInfiniteSet.addBack(value);
                    results.add(null);
                }
                case "popSmallest" -> {
                    assert handlingSmallestInfiniteSet != null;
                    int element = handlingSmallestInfiniteSet.popSmallest();
                    results.add(element);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
