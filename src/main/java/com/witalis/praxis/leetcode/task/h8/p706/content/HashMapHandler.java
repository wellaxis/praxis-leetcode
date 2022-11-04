package com.witalis.praxis.leetcode.task.h8.p706.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Hash map operations handler
 * User: Wellaxis
 * Date: 4/11/2022
 */
@Slf4j
public final class HashMapHandler {

    private HashMapHandler() {
        super();
    }

    public static <K, V> List<String> process(
        List<AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<K, V>>> operations,
        HashMap<K, V> hashMap
    ) {
        List<String> results = new ArrayList<>();

        HashMap<K, V> handlingHashMap = null;

        for (AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<K, V>> operation: operations) {
            var name = operation.getKey();
            K key = null;
            V value = null;
            if (operation.getValue() != null) {
                key = operation.getValue().getKey();
                value = operation.getValue().getValue();
            }
            switch (name) {
                case "MyHashMap" -> {
                    assert handlingHashMap == null;
                    handlingHashMap = hashMap;
                    results.add(null);
                }
                case "put" -> {
                    assert handlingHashMap != null;
                    handlingHashMap.put(key, value);
                    results.add(key + " -> " + value);
                }
                case "get" -> {
                    assert handlingHashMap != null;
                    value = handlingHashMap.get(key);
                    results.add(String.valueOf(value));
                }
                case "remove" -> {
                    assert handlingHashMap != null;
                    handlingHashMap.remove(key);
                    results.add(key + " -> " + "''");
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
