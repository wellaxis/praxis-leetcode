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
 * URL: https://leetcode.com/problems/implement-queue-using-stacks/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyQueue implements NormalQueue {
        private Stack<Integer> stack = new Stack<>();
        private int capacity;

        public MyQueue() {
            super();
        }

        @Override
        public void push(int x) {
            List<Integer> cache = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                cache.add(i, stack.pop());
            }
            stack.push(x);
            for (int i = capacity - 1; i >= 0; i--) {
                stack.push(cache.get(i));
            }
            capacity++;
        }

        @Override
        public int pop() {
            capacity--;
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
