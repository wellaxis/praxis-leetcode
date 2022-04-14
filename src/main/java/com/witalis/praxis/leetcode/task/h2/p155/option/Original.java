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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MinStack implements MinimalStack {
        private final List<Integer> values;

        public MinStack() {
            values = new ArrayList<>();
        }

        public void push(int val) {
            values.add(val);
        }

        public void pop() {
            values.remove(values.size() - 1);
        }

        public int top() {
            return values.get(values.size() - 1);
        }

        public int getMin() {
            return Collections.min(values);
        }
    }

    public List<Integer> process() {
        return StackHandler.process(operations, new MinStack());
    }
}
