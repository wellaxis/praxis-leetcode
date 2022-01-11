package com.witalis.praxis.leetcode.task.h2.p155.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Stack operations handler
 * User: Wellaxis
 * Date: 11.01.2022
 */
@Slf4j
public final class StackHandler {

    private StackHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        MinimalStack minimalStack
    ) {
        List<Integer> results = new ArrayList<>();

        MinimalStack stack = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "MinStack" -> {
                    assert stack == null;
                    stack = minimalStack;
                    results.add(null);
                }
                case "push" -> {
                    assert stack != null;
                    stack.push(value);
                    results.add(null);
                }
                case "getMin" -> {
                    assert stack != null;
                    int min = stack.getMin();
                    results.add(min);
                }
                case "pop" -> {
                    assert stack != null;
                    stack.pop();
                    results.add(null);
                }
                case "top" -> {
                    assert stack != null;
                    int top = stack.top();
                    results.add(top);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
