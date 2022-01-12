package com.witalis.praxis.leetcode.task.h1.p22.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 22
 * Name: Generate Parentheses
 * URL: https://leetcode.com/problems/generate-parentheses/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public List<String> process() {
        return generateParenthesis(number);
    }

    public List<String> generateParenthesis(int n) {
        return fillParenthesis(List.of(""), n, 0);
    }

    private List<String> fillParenthesis(List<String> parenthesis, int n, int balance) {
        if (n == 0) return parenthesis;

        if (balance == 0) {
            return openParenthesis(parenthesis, n, balance);
        } else {
            List<String> result = closeParenthesis(parenthesis, n, balance);
            if (balance < n) result.addAll(openParenthesis(parenthesis, n, balance));
            return result;
        }
    }

    private List<String> openParenthesis(List<String> parenthesis, int n, int balance) {
        List<String> list = new ArrayList<>();
        parenthesis.forEach(p -> list.add(p + "("));
        return fillParenthesis(list, n, balance + 1);
    }

    private List<String> closeParenthesis(List<String> parenthesis, int n, int balance) {
        List<String> list = new ArrayList<>();
        parenthesis.forEach(p -> list.add(p + ")"));
        return fillParenthesis(list, n - 1, balance - 1);
    }
}
