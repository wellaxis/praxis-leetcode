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
 * URL: <a href="https://leetcode.com/problems/implement-stack-using-queues/">Implement Stack using Queues</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyStack implements NormalStack {
        private Queue<Integer> queue;

        public MyStack() {
            this.queue = new ArrayDeque<>();
        }

        @Override
        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < queue.size() - 1; i++) queue.offer(queue.poll());
        }

        @Override
        public int pop() {
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
