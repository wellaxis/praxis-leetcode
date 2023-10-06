package com.witalis.praxis.leetcode.task.h2.p132.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 132
 * Name: Palindrome Partitioning II
 * URL: <a href="https://leetcode.com/problems/palindrome-partitioning-ii/">Palindrome Partitioning II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Practice(String string) {
        this.string = string;
    }

    public Integer process() {
        return minCut(string);
    }

    private int minimalCuts;
    private boolean[][] dp;

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;

        final int len = s.length();

        this.minimalCuts = Integer.MAX_VALUE;
        this.dp = new boolean[len][len];

        solver(s, 0, new ArrayList<>());

        return minimalCuts - 1;
    }

    private void solver(String s, int index, List<String> partition) {
        if (partition.size() >= minimalCuts) return;
        if (index >= s.length()) {
            minimalCuts = partition.size();
            return;
        }

        for (int end = index; end < s.length(); end++) {
            if (s.charAt(index) == s.charAt(end) && (end - index <= 2 || dp[index + 1][end - 1])) {
                dp[index][end] = true;
                partition.add(s.substring(index, end + 1));
                solver(s, end + 1, partition);
                partition.remove(partition.size() - 1);
            }
        }
    }
}
