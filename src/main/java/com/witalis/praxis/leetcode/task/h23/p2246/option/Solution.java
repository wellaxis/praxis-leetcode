package com.witalis.praxis.leetcode.task.h23.p2246.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2246
 * Name: Longest Path With Different Adjacent Characters
 * URL: <a href="https://leetcode.com/problems/longest-path-with-different-adjacent-characters/">Longest Path With Different Adjacent Characters</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] parents;
    private String labels;

    public Integer process() {
        return longestPath(parents, labels);
    }

    public int longestPath(int[] parent, String s) {
        char[] letters = s.toCharArray();
        int n = letters.length;
        int res = 1;

        int[] degree = new int[n];
        for (int i = 1; i < n; i++) {
            degree[parent[i]]++;
        }

        int[] queue = new int[n];
        int queueIndex = -1;
        for (int i = 1; i < n; i++) {
            if (degree[i] == 0) queue[++queueIndex] = i;
        }

        // max length of path for each node
        int[] path = new int[n];
        // every node is a path of length 1
        Arrays.fill(path, 1);

        while (queueIndex >= 0) {
            int childIndex = queue[queueIndex--];
            int parentIndex = parent[childIndex];

            if (--degree[parentIndex] == 0 && parentIndex != 0) {
                queue[++queueIndex] = parentIndex;
            }

            if (letters[parentIndex] == letters[childIndex]) continue;

            // we must update res first, otherwise we may double count the same path
            res = Math.max(res, path[parentIndex] + path[childIndex]);
            path[parentIndex] = Math.max(path[parentIndex], path[childIndex] + 1);
        }

        return res;
    }
}
