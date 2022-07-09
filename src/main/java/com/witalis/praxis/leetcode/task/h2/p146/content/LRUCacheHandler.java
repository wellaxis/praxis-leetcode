package com.witalis.praxis.leetcode.task.h2.p146.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: LRU cache operations handler
 * User: Wellaxis
 * Date: 9/7/2022
 */
@Slf4j
public final class LRUCacheHandler {

    private LRUCacheHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        ILRUCache lruCache
    ) {
        List<Integer> results = new ArrayList<>();

        ILRUCache handlerCache = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "LRUCache" -> {
                    assert handlerCache == null;
                    handlerCache = lruCache;
                    results.add(null);
                }
                case "put" -> {
                    assert handlerCache != null;
                    handlerCache.put(value, value);
                    results.add(null);
                }
                case "get" -> {
                    assert handlerCache != null;
                    Integer result = handlerCache.get(value);
                    results.add(result);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
