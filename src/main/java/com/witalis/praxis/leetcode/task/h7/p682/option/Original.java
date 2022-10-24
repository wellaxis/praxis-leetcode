package com.witalis.praxis.leetcode.task.h7.p682.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 682
 * Name: Baseball Game
 * URL: <a href="https://leetcode.com/problems/baseball-game/">Baseball Game</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] operations;

    public Integer process() {
        return calPoints(operations);
    }

    public int calPoints(String[] operations) {
        if (operations == null || operations.length == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    int sum = stack.pop() + stack.peek();
                    stack.push(sum - stack.peek());
                    stack.push(sum);
                }
                case "C" -> stack.pop();
                case "D" -> stack.push(2 * stack.peek());
                default -> stack.push(Integer.valueOf(operation));
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
