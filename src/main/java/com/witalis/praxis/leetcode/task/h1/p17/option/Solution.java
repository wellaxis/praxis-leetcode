package com.witalis.praxis.leetcode.task.h1.p17.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * ID: 17
 * Name: Letter Combinations of a Phone Number
 * URL: <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String digits;

    public List<String> process() {
        return letterCombinations(digits);
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() == 0) {
            return res;
        }
        res.add("");
        while (res.peek().length() != digits.length()) {
            String temp = res.pop();
            String str = map[digits.charAt(temp.length()) - '0'];
            for (char c : str.toCharArray()) {
                res.add(temp + c);
            }
        }
        return res;
    }
}
