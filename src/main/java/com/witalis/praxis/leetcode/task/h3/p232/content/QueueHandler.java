package com.witalis.praxis.leetcode.task.h3.p232.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Queue operations handler
 * User: Wellaxis
 * Date: 05.04.2022
 */
@Slf4j
public final class QueueHandler {

    private QueueHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        NormalQueue normalQueue
    ) {
        List<String> results = new ArrayList<>();

        NormalQueue queue = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "MyQueue" -> {
                    assert queue == null;
                    queue = normalQueue;
                    results.add(null);
                }
                case "push" -> {
                    assert queue != null;
                    queue.push(value);
                    results.add(null);
                }
                case "pop" -> {
                    assert queue != null;
                    int pop = queue.pop();
                    results.add(String.valueOf(pop));
                }
                case "peek" -> {
                    assert queue != null;
                    int peek = queue.peek();
                    results.add(String.valueOf(peek));
                }
                case "empty" -> {
                    assert queue != null;
                    boolean empty = queue.empty();
                    results.add(String.valueOf(empty));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
