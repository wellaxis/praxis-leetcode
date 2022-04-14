package com.witalis.praxis.leetcode.task.h3.p225.option;

import com.witalis.praxis.leetcode.task.h3.p225.content.NormalStack;
import com.witalis.praxis.leetcode.task.h3.p225.content.StackHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ID: 225
 * Name: Implement Stack using Queues
 * URL: <a href="https://leetcode.com/problems/implement-stack-using-queues/">Implement Stack using Queues</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyStack implements NormalStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
        }

        @Override
        public void push(int x) {
            if (empty()) {
                queue1.offer(x);
            } else {
                queue2.offer(x);
                while (!empty()) {
                    queue2.offer(queue1.poll());
                }
                // swap queues
                Queue<Integer> tmp = queue2;
                queue2 = queue1;
                queue1 = tmp;
            }
        }

        @Override
        public int pop() {
            return queue1.poll();
        }

        @Override
        public int top() {
            return queue1.peek();
        }

        @Override
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    public List<String> process() {
        return StackHandler.process(operations, new MyStack());
    }
}
