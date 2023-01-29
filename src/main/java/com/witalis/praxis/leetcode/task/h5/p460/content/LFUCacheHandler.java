package com.witalis.praxis.leetcode.task.h5.p460.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: LFU cache operations handler
 * User: Wellaxis
 * Date: 29/1/2023
 */
@Slf4j
public final class LFUCacheHandler {

    private LFUCacheHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, int[]>> operations,
        ILFUCache lfuCache
    ) {
        List<Integer> results = new ArrayList<>();
        ILFUCache handlerCache = null;
        for (AbstractMap.SimpleEntry<String, int[]> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "LFUCache" -> {
                    assert handlerCache == null;
                    handlerCache = lfuCache;
                    results.add(value[0]);
                }
                case "put" -> {
                    assert handlerCache != null;
                    handlerCache.put(value[0], value[1]);
                    results.add(null);
                }
                case "get" -> {
                    assert handlerCache != null;
                    Integer result = handlerCache.get(value[0]);
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
