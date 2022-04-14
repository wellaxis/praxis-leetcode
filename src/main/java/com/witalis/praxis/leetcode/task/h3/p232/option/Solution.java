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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class MyQueue implements NormalQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        @Override
        public void push(int x) {
            stack1.push(x);
        }

        @Override
        public int pop() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.peek());
                    stack1.pop();
                }
            }
            int num = stack2.peek();
            stack2.pop();
            return num;
        }

        @Override
        public int peek() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.peek());
                    stack1.pop();
                }
            }
            return stack2.peek();
        }

        @Override
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    public List<String> process() {
        return QueueHandler.process(operations, new MyQueue());
    }
}
