package com.witalis.praxis.leetcode.task.h3.p225.option;

import com.witalis.praxis.leetcode.task.h3.p225.content.NormalStack;
import com.witalis.praxis.leetcode.task.h3.p225.content.StackHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * ID: 225
 * Name: Implement Stack using Queues
 * URL: https://leetcode.com/problems/implement-stack-using-queues/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyStack implements NormalStack {
        private Queue<Integer> queue = new ArrayDeque<>();
        private int capacity;

        public MyStack() {
            super();
        }

        @Override
        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < capacity; i++) {
                int element = queue.poll();
                queue.offer(element);
            }
            capacity++;
        }

        @Override
        public int pop() {
            capacity--;
            return queue.poll();
        }

        @Override
        public int top() {
            return queue.peek();
        }

        @Override
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public List<String> process() {
        return StackHandler.process(operations, new MyStack());
    }
}
