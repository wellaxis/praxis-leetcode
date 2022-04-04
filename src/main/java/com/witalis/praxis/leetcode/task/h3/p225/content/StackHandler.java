package com.witalis.praxis.leetcode.task.h3.p225.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Stack operations handler
 * User: Wellaxis
 * Date: 04.04.2022
 */
@Slf4j
public final class StackHandler {

    private StackHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        NormalStack normalStack
    ) {
        List<String> results = new ArrayList<>();

        NormalStack stack = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "MyStack" -> {
                    assert stack == null;
                    stack = normalStack;
                    results.add(null);
                }
                case "push" -> {
                    assert stack != null;
                    stack.push(value);
                    results.add(null);
                }
                case "pop" -> {
                    assert stack != null;
                    int pop = stack.pop();
                    results.add(String.valueOf(pop));
                }
                case "top" -> {
                    assert stack != null;
                    int top = stack.top();
                    results.add(String.valueOf(top));
                }
                case "empty" -> {
                    assert stack != null;
                    boolean empty = stack.empty();
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
