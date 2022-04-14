package com.witalis.praxis.leetcode.task.h2.p155.option;

import com.witalis.praxis.leetcode.task.h2.p155.content.MinimalStack;
import com.witalis.praxis.leetcode.task.h2.p155.content.StackHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 155
 * Name: Min Stack
 * URL: <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class MinStack implements MinimalStack {
        private final List<Entry> entries;
        private Entry currentMin;

        /**
         * Inner entry class, stores value and link to previous minimal entry.
         */
        final class Entry {
            private final int value;
            private final Entry previousMin;

            public Entry(int value, Entry previousMin) {
                this.value = value;
                this.previousMin = previousMin;
            }
        }

        public MinStack() {
            entries = new ArrayList<>();
        }

        public void push(int val) {
            int index = entries.size();

            Entry entry;
            if (currentMin != null && currentMin.value > val) {
                entry = new Entry(val, currentMin);
                currentMin = entry;
            } else {
                entry = new Entry(val, null);
                if (currentMin == null) currentMin = entry;
            }
            entries.add(index, entry);
        }

        public void pop() {
            Entry entry = entries.get(entries.size() - 1);
            if (entry.equals(currentMin)) {
                currentMin = entry.previousMin;
            }
            entries.remove(entry);
        }

        public int top() {
            return entries.get(entries.size() - 1).value;
        }

        public int getMin() {
            return currentMin.value;
        }
    }

    public List<Integer> process() {
        return StackHandler.process(operations, new MinStack());
    }
}
