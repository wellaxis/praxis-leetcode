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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    @SuppressWarnings("unchecked")
    class SnapshotArray implements ISnapshotArray {
        private final NavigableMap<Integer, Integer>[] snaps;
        private int snapCounter;

        public SnapshotArray(int length) {
            this.snaps = new TreeMap[length];
            this.snapCounter = 0;

            for (int i = 0; i < length; i++) {
                var map = new TreeMap<Integer, Integer>();
                map.put(snapCounter, 0);
                snaps[i] = map;
            }
        }

        @Override
        public void set(int index, int val) {
            snaps[index].put(snapCounter, val);
        }

        @Override
        public int snap() {
            return snapCounter++;
        }

        @Override
        public int get(int index, int snapId) {
            return snaps[index].floorEntry(snapId).getValue();
        }
    }

    public List<Integer> process() {
        int length = operations.get(0).getValue()[0];

        return SnapshotArrayHandler.process(operations, new SnapshotArray(length));
    }
}
