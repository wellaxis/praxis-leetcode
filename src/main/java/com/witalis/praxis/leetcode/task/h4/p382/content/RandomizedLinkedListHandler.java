package com.witalis.praxis.leetcode.task.h4.p382.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Randomized linked list operations handler
 * User: Wellaxis
 * Date: 03/10/2023
 */
@Slf4j
public final class RandomizedLinkedListHandler {

    private RandomizedLinkedListHandler() {
        super();
    }

    public static List<Integer> process(
        List<AbstractMap.SimpleEntry<String, ListNode>> operations,
        RandomizableLinkedList<Integer> randomizableLinkedList
    ) {
        List<Integer> results = new ArrayList<>();
        RandomizableLinkedList<Integer> randomizedLinkedList = null;

        for (AbstractMap.SimpleEntry<String, ListNode> operation: operations) {
            var name = operation.getKey();
            switch (name) {
                case "RandomizedLinkedList" -> {
                    assert randomizedLinkedList == null;
                    randomizedLinkedList = randomizableLinkedList;
                    results.add(null);
                }
                case "getRandom" -> {
                    assert randomizedLinkedList != null;
                    var random = randomizedLinkedList.getRandom();
                    results.add(random);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
