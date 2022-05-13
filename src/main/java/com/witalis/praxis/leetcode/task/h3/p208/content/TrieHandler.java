package com.witalis.praxis.leetcode.task.h3.p208.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Trie operations handler
 * User: Wellaxis
 * Date: 5/13/2022
 */
@Slf4j
public final class TrieHandler {

    private TrieHandler() {
        super();
    }

    public static List<Boolean> process(
        List<AbstractMap.SimpleEntry<String, String>> operations,
        ITrie trie
    ) {
        List<Boolean> results = new ArrayList<>();

        ITrie handlerTrie = null;

        for (AbstractMap.SimpleEntry<String, String> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "Trie" -> {
                    assert handlerTrie == null;
                    handlerTrie = trie;
                    results.add(null);
                }
                case "insert" -> {
                    assert handlerTrie != null;
                    handlerTrie.insert(value);
                    results.add(null);
                }
                case "search" -> {
                    assert handlerTrie != null;
                    boolean result = handlerTrie.search(value);
                    results.add(result);
                }
                case "startsWith" -> {
                    assert handlerTrie != null;
                    boolean result = handlerTrie.startsWith(value);
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
