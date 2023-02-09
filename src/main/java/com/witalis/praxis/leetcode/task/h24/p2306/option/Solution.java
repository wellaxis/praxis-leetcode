package com.witalis.praxis.leetcode.task.h24.p2306.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 2306
 * Name: Naming a Company
 * URL: <a href="https://leetcode.com/problems/naming-a-company/">Naming a Company</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] ideas;

    public Long process() {
        return distinctNames(ideas);
    }

    public long distinctNames(String[] ideas) {
        Set<String>[] sets = new Set[26];
        for (int i = 0; i < 26; i++) {
            sets[i] = new HashSet<>();
        }
        for (String s : ideas) {
            sets[s.charAt(0) - 'a'].add(s.substring(1));
        }

        int[][] same = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (String s : sets[i]) {
                for (int j = i + 1; j < 26; j++) {
                    if (sets[j].contains(s)) {
                        same[i][j]++;
                    }
                }
            }
        }

        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                res += (long) (sets[i].size() - same[i][j]) * (sets[j].size() - same[i][j]) * 2;
            }
        }

        return res;
    }
}
