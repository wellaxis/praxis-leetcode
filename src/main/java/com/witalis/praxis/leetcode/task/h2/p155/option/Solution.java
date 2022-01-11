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
 * URL: https://leetcode.com/problems/min-stack/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class MinStack implements MinimalStack {
        private final Deque<Integer> stack;
        private final Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            int curr = minStack.isEmpty() ? x : minStack.peek();
            minStack.push(Math.min(curr, x));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public List<Integer> process() {
        return StackHandler.process(operations, new MinStack());
    }
}
