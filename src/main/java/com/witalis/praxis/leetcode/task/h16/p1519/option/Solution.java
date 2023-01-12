package com.witalis.praxis.leetcode.task.h16.p1519.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1519
 * Name: Number of Nodes in the Sub-Tree With the Same Label
 * URL: <a href="https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/">Number of Nodes in the Sub-Tree With the Same Label</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[][] edges;
    private String labels;

    public int[] process() {
        return countSubTrees(number, edges, labels);
    }

    @SuppressWarnings("unchecked")
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        helper(graph, ans, 0, -1, labels);
        return ans;
    }

    public int[] helper(List<Integer>[] graph, int[] ans, int cur, int parent, String labels) {
        int[] cnt = new int[26];
        for (int next : graph[cur]) {
            if (next == parent) continue;
            int[] arr = helper(graph, ans, next, cur, labels);
            for (int i = 0; i < 26; i++) {
                cnt[i] = cnt[i] + arr[i];
            }
        }
        char c = labels.charAt(cur);
        cnt[c - 'a']++;
        ans[cur] = cnt[c - 'a'];
        return cnt;
    }
}
