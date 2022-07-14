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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] tokens;

    public Integer process() {
        return evalRPN(tokens);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Set<String> operators = Set.of("+", "-", "*", "/");
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int the2nd = stack.pop();
                int the1st = stack.pop();
                int result = switch (token) {
                    case "+" -> the1st + the2nd;
                    case "-" -> the1st - the2nd;
                    case "*" -> the1st * the2nd;
                    case "/" -> the1st / the2nd;
                    default -> throw new IllegalArgumentException("Unexpected operation: " + token);
                };
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
