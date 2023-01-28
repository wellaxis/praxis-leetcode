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
 * Name: Data Stream as Disjoint Intervals
 * URL: <a href="https://leetcode.com/problems/data-stream-as-disjoint-intervals/">Data Stream as Disjoint Intervals</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class SummaryRanges implements SummableRanges {
        public static final int SIZE = 10_000;
        private boolean[] seen;
        private int[] extrema;

        public SummaryRanges() {
            this.seen = new boolean[SIZE + 1];
            this.extrema = new int[] {SIZE + 1, -1};
        }

        @Override
        public void addNum(int value) {
            seen[value] = true;
            extrema[0] = Math.min(extrema[0], value);
            extrema[1] = Math.max(extrema[1], value);
        }

        @Override
        public int[][] getIntervals() {
            final List<int[]> intervals = new ArrayList<>();
            for (int i = extrema[0]; i <= extrema[1]; i++) {
                if (seen[i]) {
                    final int[] interval = {i, i};

                    do {
                        i++;
                    } while (i <= extrema[1] && seen[i]);

                    interval[1] = i - 1;
                    intervals.add(interval);
                }
            }

            return intervals.toArray(new int[intervals.size()][]);
        }
    }

    public List<String> process() {
        return SummableRangesHandler.process(operations, new SummaryRanges());
    }
}
