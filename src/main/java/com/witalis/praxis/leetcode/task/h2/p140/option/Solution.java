package com.witalis.praxis.leetcode.task.h2.p140.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 140
 * Name: Word Break II
 * URL: <a href="https://leetcode.com/problems/word-break-ii/">Word Break II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private List<String> wordDict;

    public List<String> process() {
        return wordBreak(string, wordDict);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordDict);

        backtracking(result, wordSet, s, new StringBuilder(), 0);

        return result;
    }

    private void backtracking(List<String> result, Set<String> wordSet, String s, StringBuilder sb, int index) {
        if (index == s.length()) {
            result.add(sb.toString());
            return;
        }

        int length = sb.length();
        for (int i = index + 1; i <= s.length(); i++) {
            if (wordSet.contains(s.substring(index, i))) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(s.substring(index, i));
                backtracking(result, wordSet, s, sb, i);
                sb.setLength(length);
            }
        }
    }
}
