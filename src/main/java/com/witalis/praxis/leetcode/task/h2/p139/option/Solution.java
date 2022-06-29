package com.witalis.praxis.leetcode.task.h2.p139.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ID: 139
 * Name: Word Break
 * URL: <a href="https://leetcode.com/problems/word-break/">Word Break</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private List<String> wordDict;

    public Boolean process() {
        return wordBreak(string, wordDict);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0, new boolean[s.length()]);
    }

    private static boolean wordBreak(String s, List<String> wordDict, int startIndex, boolean[] visited) {
        if (s.length() == startIndex) return true;
        if (visited[startIndex]) return false;

        visited[startIndex] = true;
        for (var word : wordDict) {
            if (s.startsWith(word, startIndex) && wordBreak(s, wordDict, startIndex + word.length(), visited)) {
                return true;
            }
        }

        return false;
    }
}
