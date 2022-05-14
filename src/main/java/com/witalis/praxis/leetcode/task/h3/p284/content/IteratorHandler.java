package com.witalis.praxis.leetcode.task.h3.p284.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Desc: Iterator operations handler
 * User: Wellaxis
 * Date: 5/14/2022
 */
@Slf4j
public final class IteratorHandler {

    private IteratorHandler() {
        super();
    }

    public static <E> List<String> process(
        List<AbstractMap.SimpleEntry<String, Iterator<E>>> operations,
        PeekIterator<E> iterator
    ) {
        List<String> results = new ArrayList<>();

        PeekIterator<E> handlerIterator = null;

        for (AbstractMap.SimpleEntry<String, Iterator<E>> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "PeekingIterator" -> {
                    assert handlerIterator == null;
                    handlerIterator = iterator;
                    iterator.init(value);
                    results.add(null);
                }
                case "peek" -> {
                    assert handlerIterator != null;
                    E element = handlerIterator.peek();
                    results.add(String.valueOf(element));
                }
                case "next" -> {
                    assert handlerIterator != null;
                    E element = handlerIterator.next();
                    results.add(String.valueOf(element));
                }
                case "hasNext" -> {
                    assert handlerIterator != null;
                    boolean result = handlerIterator.hasNext();
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
