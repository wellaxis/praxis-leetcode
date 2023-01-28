package com.witalis.praxis.leetcode.task.h4.p352.option;

import com.witalis.praxis.leetcode.task.h4.p352.content.SummableRanges;
import com.witalis.praxis.leetcode.task.h4.p352.content.SummableRangesHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 352
 * Name: Data Stream as Disjoint Intervalues
 * URL: <a href="https://leetcode.com/problems/data-stream-as-disjoint-intervals/">Data Stream as Disjoint Intervalues</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class SummaryRanges implements SummableRanges {
        private TreeMap<Integer, Integer> intervals;

        public SummaryRanges() {
            this.intervals = new TreeMap<>();
        }

        @Override
        public void addNum(int value) {
            int left = value;
            int right = value;

            final Map.Entry<Integer, Integer> smallEntry = intervals.floorEntry(value);
            if (smallEntry != null) {
                final int previous = smallEntry.getValue();
                if (previous >= value) {
                    return;
                }
                if (previous == value - 1) {
                    left = smallEntry.getKey();
                }
            }

            final Map.Entry<Integer, Integer> maxEntry = intervals.higherEntry(value);
            if (maxEntry != null && maxEntry.getKey() == value + 1) {
                right = maxEntry.getValue();
                intervals.remove(value + 1);
            }

            intervals.put(left, right);
        }

        @Override
        public int[][] getIntervals() {
            final int[][] answer = new int[intervals.size()][2];

            int index = 0;
            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                answer[index][0] = entry.getKey();
                answer[index++][1] = entry.getValue();
            }

            return answer;
        }
    }

    public List<String> process() {
        return SummableRangesHandler.process(operations, new SummaryRanges());
    }
}
