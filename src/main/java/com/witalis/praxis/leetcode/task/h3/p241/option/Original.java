package com.witalis.praxis.leetcode.task.h3.p241.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 241
 * Name: Different Ways to Add Parentheses
 * URL: <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">Different Ways to Add Parentheses</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String expression;

    public List<Integer> process() {
        return diffWaysToCompute(expression);
    }

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.isEmpty()) return Collections.emptyList();

        List<Integer> results = new ArrayList<>();

        if (expression.contains("-") || expression.contains("+") || expression.contains("*")) {
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '-' || c == '+' || c == '*') {
                    List<Integer> preResults = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> postResults = diffWaysToCompute(expression.substring(i + 1));
                    for (int l = 0; l < preResults.size(); l++) {
                        for (int r = 0; r < postResults.size(); r++) {
                            int result = switch (c) {
                                case '-' -> preResults.get(l) - postResults.get(r);
                                case '+' -> preResults.get(l) + postResults.get(r);
                                case '*' -> preResults.get(l) * postResults.get(r);
                                default -> throw new IllegalStateException("Unexpected operation: " + c);
                            };
                            results.add(result);
                        }
                    }
                }
            }
        } else {
            results.add(Integer.parseInt(expression));
        }

        return results;
    }
}
