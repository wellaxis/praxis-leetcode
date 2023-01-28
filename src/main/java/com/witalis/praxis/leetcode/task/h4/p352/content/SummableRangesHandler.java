package com.witalis.praxis.leetcode.task.h4.p352.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc: Summable ranges operations handler
 * User: Wellaxis
 * Date: 01/28/2023
 */
@Slf4j
public final class SummableRangesHandler {

    private SummableRangesHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, Integer>> operations,
        SummableRanges summableRanges
    ) {
        List<String> results = new ArrayList<>();
        SummableRanges summaryRanges = null;

        for (AbstractMap.SimpleEntry<String, Integer> operation: operations) {
            var name = operation.getKey();
            var data = operation.getValue();
            switch (name) {
                case "SummaryRanges" -> {
                    assert summaryRanges == null;
                    summaryRanges = summableRanges;
                    results.add(null);
                }
                case "addNum" -> {
                    assert summaryRanges != null;
                    summaryRanges.addNum(data);
                    results.add("{" + data + "}");
                }
                case "getIntervals" -> {
                    assert summaryRanges != null;
                    int[][] intervals = summaryRanges.getIntervals();
                    results.add(Arrays.deepToString(intervals));
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
