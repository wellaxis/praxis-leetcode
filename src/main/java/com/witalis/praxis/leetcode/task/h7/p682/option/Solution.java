package com.witalis.praxis.leetcode.task.h7.p682.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * ID: 682
 * Name: Baseball Game
 * URL: <a href="https://leetcode.com/problems/baseball-game/">Baseball Game</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] operations;

    public Integer process() {
        return calPoints(operations);
    }

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
}
