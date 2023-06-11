package com.witalis.praxis.leetcode.task.h12.p1146.option;

import com.witalis.praxis.leetcode.task.h12.p1146.content.ISnapshotArray;
import com.witalis.praxis.leetcode.task.h12.p1146.content.SnapshotArrayHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1146
 * Name: Snapshot Array
 * URL: <a href="https://leetcode.com/problems/snapshot-array/">Snapshot Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    @SuppressWarnings("unchecked")
    class SnapshotArray implements ISnapshotArray {
        private List<int[]>[] snaps;
        private int snapId = 0;

        public SnapshotArray(int length) {
            this.snaps = new List[length];
            for (int i = 0; i < length; ++i) {
                snaps[i] = new ArrayList<>();
                snaps[i].add(new int[] {0, 0});
            }
        }

        @Override
        public void set(int index, int val) {
            int[] snap = snaps[index].get(snaps[index].size() - 1);
            if (snap[0] == snapId)
                snap[1] = val;
            else
                snaps[index].add(new int[] {snapId, val});
        }

        @Override
        public int snap() {
            return snapId++;
        }

        @Override
        public int get(int index, int snapId) {
            int i = Collections.binarySearch(
                snaps[index],
                new int[] {snapId, 0},
                Comparator.comparingInt(a -> a[0])
            );
            if (i < 0) i = -i - 2;

            return snaps[index].get(i)[1];
        }
    }

    public List<Integer> process() {
        int length = operations.get(0).getValue()[0];

        return SnapshotArrayHandler.process(operations, new SnapshotArray(length));
    }
}
