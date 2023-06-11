package com.witalis.praxis.leetcode.task.h12.p1146.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Snapshot array handler
 * User: Wellaxis
 * Date: 11.06.2023
 */
@Slf4j
public class SnapshotArrayHandler {

    private SnapshotArrayHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, int[]>> operations,
        ISnapshotArray snapshotArray
    ) {
        List<Integer> results = new ArrayList<>();

        ISnapshotArray handlerSnapshotArray = null;

        for (AbstractMap.SimpleEntry<String, int[]> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "SnapshotArray" -> {
                    assert handlerSnapshotArray == null;
                    handlerSnapshotArray = snapshotArray;
                    results.add(null);
                }
                case "set" -> {
                    assert handlerSnapshotArray != null;
                    handlerSnapshotArray.set(value[0], value[1]);
                    results.add(null);
                }
                case "snap" -> {
                    assert handlerSnapshotArray != null;
                    int id = handlerSnapshotArray.snap();
                    results.add(id);
                }
                case "get" -> {
                    assert handlerSnapshotArray != null;
                    int val = handlerSnapshotArray.get(value[0], value[1]);
                    results.add(val);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
