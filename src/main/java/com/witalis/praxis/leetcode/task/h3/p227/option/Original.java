package com.witalis.praxis.leetcode.task.h3.p227.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * ID: 227
 * Name: Basic Calculator II
 * URL: <a href="https://leetcode.com/problems/basic-calculator-ii/">Basic Calculator II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String expression;

    public Integer process() {
        return calculate(expression);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        int calculation = 0;
        s = s.trim().concat("+");

        Deque<Integer> stack = new ArrayDeque<>();
        Set<Character> operations = Set.of('+', '-', '*', '/');

        int operand = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;

            if (operations.contains(ch)) {
                switch (operator) {
                    case '+' -> stack.push(operand);
                    case '-' -> stack.push(-operand);
                    case '*' -> stack.push(stack.pop() * operand);
                    case '/' -> stack.push(stack.pop() / operand);
                    default -> throw new IllegalStateException("Unexpected operation: " + operator);
                }
                operator = ch;
                operand = 0;
            } else {
                operand = operand * 10 + ch - '0';
            }
        }

        while (!stack.isEmpty()) calculation += stack.pop();

        return calculation;
    }
}
