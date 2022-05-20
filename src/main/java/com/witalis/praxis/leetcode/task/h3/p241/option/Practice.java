package com.witalis.praxis.leetcode.task.h3.p241.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ID: 241
 * Name: Different Ways to Add Parentheses
 * URL: <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">Different Ways to Add Parentheses</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String expression;

    public Practice(String expression) {
        this.expression = expression;
    }

    public List<Integer> process() {
        return diffWaysToCompute(expression);
    }

    private Map<String, List<Integer>> cache = new ConcurrentHashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.isEmpty()) return Collections.emptyList();

        if (!expression.contains("-") && !expression.contains("+") && !expression.contains("*")) {
            return new ArrayList<>(List.of(Integer.parseInt(expression)));
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                // pre-processing
                String preExpression = expression.substring(0, i);
                cache.putIfAbsent(preExpression, diffWaysToCompute(preExpression));
                // post-processing
                String postExpression = expression.substring(i + 1);
                cache.putIfAbsent(postExpression, diffWaysToCompute(postExpression));
                // calculation
                for (Integer preResult : cache.get(preExpression)) {
                    for (Integer postResult : cache.get(postExpression)) {
                        int result = switch (c) {
                            case '-' -> preResult - postResult;
                            case '+' -> preResult + postResult;
                            case '*' -> preResult * postResult;
                            default -> throw new IllegalStateException("Unexpected operation: " + c);
                        };
                        results.add(result);
                    }
                }
            }
        }

        return results;
    }
}
