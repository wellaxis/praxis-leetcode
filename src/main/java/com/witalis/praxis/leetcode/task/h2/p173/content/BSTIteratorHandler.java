package com.witalis.praxis.leetcode.task.h2.p173.content;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: BST iterator operations handler
 * User: Wellaxis
 * Date: 31.07.2022
 */
@Slf4j
public final class BSTIteratorHandler {

    private BSTIteratorHandler() {
        super();
    }

    public static List<String> process(
        List<String> operations,
        IBSTIterator bstIterator
    ) {
        List<String> results = new ArrayList<>();

        IBSTIterator iterator = null;

        for (String operation: operations) {
            switch (operation) {
                case "BSTIterator" -> {
                    assert iterator == null;
                    iterator = bstIterator;
                    results.add(null);
                }
                case "next" -> {
                    assert iterator != null;
                    int node = iterator.next();
                    results.add(String.valueOf(node));
                }
                case "hasNext" -> {
                    assert iterator != null;
                    boolean existence = iterator.hasNext();
                    results.add(String.valueOf(existence));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
