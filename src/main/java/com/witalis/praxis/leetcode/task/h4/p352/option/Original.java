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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class SummaryRanges implements SummableRanges {
        public static final int SIZE = 10_000;
        private int[] intervals;

        public SummaryRanges() {
            this.intervals = new int[SIZE + 1];
            Arrays.fill(intervals, Integer.MIN_VALUE);
        }

        @Override
        public void addNum(int value) {
            if (intervals[value] != Integer.MIN_VALUE) return;

            int prev = value == 0 ? Integer.MIN_VALUE : intervals[value - 1];
            int next = value == SIZE ? Integer.MIN_VALUE : intervals[value + 1];

            if (prev == Integer.MIN_VALUE && next == Integer.MIN_VALUE) {
                // no join -> new interval
                intervals[value] = value;
            } else if (prev == Integer.MIN_VALUE) {
                // left join -> add as head
                intervals[value] = next;
                intervals[value + 1] = value;
            } else if (next == Integer.MIN_VALUE) {
                // right join -> add as tail
                int head = prev;
                while (intervals[head] < head) {
                    head = intervals[head];
                }
                intervals[head] = value;
                intervals[value] = head;
            } else {
                // between -> union intervals
                int head = prev;
                while (intervals[head] < head) {
                    head = intervals[head];
                }
                intervals[head] = next;
                intervals[value] = head;
                intervals[value + 1] = head;
            }
        }

        @Override
        public int[][] getIntervals() {
            List<int[]> response = new ArrayList<>();
            for (int i = 0; i <= SIZE; i++) {
                if (intervals[i] >= i) response.add(new int[] {i, intervals[i]});
            }

            return response.toArray(new int[response.size()][]);
        }
    }

    public List<String> process() {
        return SummableRangesHandler.process(operations, new SummaryRanges());
    }
}
