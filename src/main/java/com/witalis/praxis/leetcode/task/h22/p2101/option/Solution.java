package com.witalis.praxis.leetcode.task.h22.p2101.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 2101
 * Name: Detonate the Maximum Bombs
 * URL: <a href="https://leetcode.com/problems/detonate-the-maximum-bombs/">Detonate the Maximum Bombs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Solution {
    private int[][] bombs;

    public Integer process() {
        return maximumDetonation(bombs);
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dx = bombs[i][0] - bombs[j][0];
                double dy = bombs[i][1] - bombs[j][1];
                double r1 = bombs[i][2];
                double r2 = bombs[j][2];
                double dist = dx * dx + dy * dy;
                if (dist <= r1 * r1) graph[i].add(j);
                if (dist <= r2 * r2) graph[j].add(i);
            }
        }

        int ans = 0;
        for (int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[n];
            ans = Math.max(ans, dfs(graph, i, visited));
            if (ans == n) return ans;
        }

        return ans;
    }

    private int dfs(List<Integer>[] graph, int i, boolean[] visited) {
        if (visited[i]) return 0;

        int count = 0;
        visited[i] = true;
        for (int neigh : graph[i]) {
            count += dfs(graph, neigh, visited);
        }

        return count + 1;
    }
}
