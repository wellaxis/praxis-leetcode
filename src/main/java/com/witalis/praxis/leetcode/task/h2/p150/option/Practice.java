package com.witalis.praxis.leetcode.task.h2.p150.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * ID: 150
 * Name: Evaluate Reverse Polish Notation
 * URL: <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Evaluate Reverse Polish Notation</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] tokens;

    public Integer process() {
        return evalRPN(tokens);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Set<String> operators = Set.of("+", "-", "*", "/");
        Deque<Integer> stack = new ArrayDeque<>();

        int the1st;
        int the2nd;
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            the2nd = stack.pop();
            the1st = stack.pop();
            stack.push(
                switch (token) {
                    case "+" -> the1st + the2nd;
                    case "-" -> the1st - the2nd;
                    case "*" -> the1st * the2nd;
                    default -> the1st / the2nd;
                }
            );
        }

        return stack.pop();
    }
}
