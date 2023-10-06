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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Original(String string) {
        this.string = string;
    }

    public Integer process() {
        return minCut(string);
    }

    private int minimalCuts = Integer.MAX_VALUE;
    private Set<String> palindromes = new HashSet<>();

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;

        solver(s, 0, new ArrayList<>());

        return minimalCuts - 1;
    }

    private void solver(String s, int index, List<String> partition) {
        if (partition.size() >= minimalCuts) return;

        if (index >= s.length()) {
            minimalCuts = partition.size();
            return;
        }

        int begin;
        int end;
        boolean palindrome;

        for (int i = index; i < s.length(); i++) {
            String candidate = s.substring(index, i + 1);

            palindrome = true;
            if (!palindromes.contains(candidate)) {
                for (begin = index, end = i; begin < end; begin++, end--) {
                    if (s.charAt(begin) != s.charAt(end)) {
                        palindrome = false;
                        break;
                    }
                }
                if (palindrome) palindromes.add(candidate);
            }

            if (palindrome) {
                partition.add(candidate);
                solver(s, i + 1, partition);
                partition.remove(partition.size() - 1);
            }
        }
    }
}
