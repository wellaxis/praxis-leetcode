package com.witalis.praxis.leetcode.task.h4.p341.content;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Desc: Nested iterator handler
 * User: Wellaxis
 * Date: 11/22/2022
 */
@Slf4j
public final class NestedIteratorHandler {

    private NestedIteratorHandler() {
        super();
    }

    public static List<String> process(
        Iterator<Integer> iterator
    ) {
        List<String> results = new ArrayList<>();
        if (iterator != null) {
            while (iterator.hasNext()) {
                Integer integer = iterator.next();
                results.add("'" + integer + "'");
            }
        }

        return results;
    }
}
