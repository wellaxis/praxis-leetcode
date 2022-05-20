package com.witalis.praxis.leetcode.task.h3.p241.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 241
 * Name: Different Ways to Add Parentheses
 * URL: <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">Different Ways to Add Parentheses</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String expression;

    public Solution(String expression) {
        this.expression = expression;
    }

    public List<Integer> process() {
        return diffWaysToCompute(expression);
    }

    public static Set<Character> opSet = new HashSet<>();

    {
        opSet.add('+');
        opSet.add('-');
        opSet.add('*');
    }

    private Map<String, List<Integer>> strMap = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (strMap.containsKey(input)) return strMap.get(input);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (opSet.contains(ch)) {
                List<Integer> leftRes = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightRes = diffWaysToCompute(input.substring(i + 1));
                for (int lr : leftRes)
                    for (int rr : rightRes) {
                        switch (ch) {
                            case '+':
                                res.add(lr + rr);
                                break;
                            case '-':
                                res.add(lr - rr);
                                break;
                            case '*':
                                res.add(lr * rr);
                                break;
                        }
                    }
            }
        }
        if (res.isEmpty()) res.add(Integer.valueOf(input));
        strMap.put(input, res);
        return res;
    }
}
