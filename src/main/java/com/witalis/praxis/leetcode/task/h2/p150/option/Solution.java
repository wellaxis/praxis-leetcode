package com.witalis.praxis.leetcode.task.h2.p150.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 150
 * Name: Evaluate Reverse Polish Notation
 * URL: <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Evaluate Reverse Polish Notation</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] tokens;

    public Integer process() {
        return evalRPN(tokens);
    }

    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];

        int index = -1;
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    index--;
                    stack[index] += stack[index + 1];
                }
                case "-" -> {
                    index--;
                    stack[index] -= stack[index + 1];
                }
                case "*" -> {
                    index--;
                    stack[index] *= stack[index + 1];
                }
                case "/" -> {
                    index--;
                    stack[index] /= stack[index + 1];
                }
                default -> {
                    index++;
                    stack[index] = Integer.parseInt(token);
                }
            }
        }

        return stack[index];
    }
}
