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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public List<String> process() {
        return generateParenthesis(number);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        result.add("");
        return fillParenthesis(result, n, 0);
    }

    private List<String> fillParenthesis(List<String> parenthesis, int n, int balance) {
        if (n == 0) return parenthesis;

        if (balance == 0) {
            List<String> list = new ArrayList<>();
            parenthesis.forEach(p -> list.add(p + "("));
            return fillParenthesis(list, n, balance + 1);
        } else {
            List<String> list1 = new ArrayList<>();
            List<String> res1 = new ArrayList<>();
            if (balance < n) {
                parenthesis.forEach(p -> list1.add(p + "("));
                res1 = fillParenthesis(list1, n, balance + 1);
            }

            List<String> list2 = new ArrayList<>();
            parenthesis.forEach(p -> list2.add(p + ")"));
            var res2 = fillParenthesis(list2, n - 1, balance - 1);

            res1.addAll(res2);

            return res1;
        }
    }
}
