package com.witalis.praxis.leetcode.task.h3.p232.option;

import com.witalis.praxis.leetcode.task.h3.p232.content.NormalQueue;
import com.witalis.praxis.leetcode.task.h3.p232.content.QueueHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 232
 * Name: Implement Queue using Stacks
 * URL: <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Implement Queue using Stacks</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyQueue implements NormalQueue {
        private Deque<Integer> stack;
        private Deque<Integer> cache;

        public MyQueue() {
            stack = new ArrayDeque<>();
            cache = new ArrayDeque<>();
        }

        @Override
        public void push(int x) {
            while (!stack.isEmpty()) cache.push(stack.pop());
            stack.push(x);
            while (!cache.isEmpty()) stack.push(cache.pop());
        }

        @Override
        public int pop() {
            return stack.pop();
        }

        @Override
        public int peek() {
            return stack.peek();
        }

        @Override
        public boolean empty() {
            return stack.isEmpty();
        }
    }

    public List<String> process() {
        return QueueHandler.process(operations, new MyQueue());
    }
}
