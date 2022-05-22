package com.witalis.praxis.leetcode.task.h3.p211.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Word dictionary operations handler
 * User: Wellaxis
 * Date: 5/22/2022
 */
@Slf4j
public final class WordDictionaryHandler {

    private WordDictionaryHandler() {
        super();
    }

    public static List<Boolean> process(
        List<AbstractMap.SimpleEntry<String, String>> operations,
        IWordDictionary dictionary
    ) {
        List<Boolean> results = new ArrayList<>();

        IWordDictionary handlerDictionary = null;

        for (AbstractMap.SimpleEntry<String, String> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "WordDictionary" -> {
                    assert handlerDictionary == null;
                    handlerDictionary = dictionary;
                    results.add(null);
                }
                case "addWord" -> {
                    assert handlerDictionary != null;
                    handlerDictionary.addWord(value);
                    results.add(null);
                }
                case "search" -> {
                    assert handlerDictionary != null;
                    boolean result = handlerDictionary.search(value);
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
