package com.witalis.praxis.leetcode.task.h15.p1472.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Browser history operations handler
 * User: Wellaxis
 * Date: 3/18/2023
 */
@Slf4j
public final class BrowserHistoryHandler {

    private BrowserHistoryHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, String>> operations,
        IBrowserHistory browserHistory
    ) {
        List<String> results = new ArrayList<>();

        IBrowserHistory handlerBrowserHistory = null;
        for (AbstractMap.SimpleEntry<String, String> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "BrowserHistory" -> {
                    assert handlerBrowserHistory == null;
                    handlerBrowserHistory = browserHistory;
                    results.add("'" + value + "'");
                }
                case "visit" -> {
                    assert handlerBrowserHistory != null;
                    handlerBrowserHistory.visit(value);
                    results.add("'" + value + "'");
                }
                case "back" -> {
                    assert handlerBrowserHistory != null;
                    String back = handlerBrowserHistory.back(Integer.parseInt(value));
                    results.add(back);
                }
                case "forward" -> {
                    assert handlerBrowserHistory != null;
                    String forward = handlerBrowserHistory.forward(Integer.parseInt(value));
                    results.add(forward);
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
