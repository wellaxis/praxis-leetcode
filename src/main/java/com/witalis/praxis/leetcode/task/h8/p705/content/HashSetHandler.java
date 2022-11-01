package com.witalis.praxis.leetcode.task.h8.p705.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Hash set operations handler
 * User: Wellaxis
 * Date: 1/11/2022
 */
@Slf4j
public final class HashSetHandler {

    private HashSetHandler() {
        super();
    }

    public static <E> List<String> process(
        List<AbstractMap.SimpleEntry<String, E>> operations,
        HashSet<E> hashSet
    ) {
        List<String> results = new ArrayList<>();

        HashSet<E> handlingHashSet = null;

        for (AbstractMap.SimpleEntry<String, E> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "MyHashSet" -> {
                    assert handlingHashSet == null;
                    handlingHashSet = hashSet;
                    results.add(null);
                }
                case "add" -> {
                    assert handlingHashSet != null;
                    handlingHashSet.add(value);
                    results.add(String.valueOf(handlingHashSet.size()));
                }
                case "remove" -> {
                    assert handlingHashSet != null;
                    handlingHashSet.remove(value);
                    results.add(String.valueOf(handlingHashSet.size()));
                }
                case "contains" -> {
                    assert handlingHashSet != null;
                    boolean result = handlingHashSet.contains(value);
                    results.add(String.valueOf(result));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
