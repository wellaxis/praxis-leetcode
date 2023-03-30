package com.witalis.praxis.leetcode.task.h25.p2492.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ID: 2492
 * Name: Minimum Score of a Path Between Two Cities
 * URL: <a href="https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/">Minimum Score of a Path Between Two Cities</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Solution {
    private int cities;
    private int[][] roads;

    public Integer process() {
        return minScore(cities, roads);
    }

    public int minScore(int n, int[][] roads) {
        List<Integer[]>[] graph = new ArrayList[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            graph[road[0] - 1].add(new Integer[]{road[1] - 1, road[2]});
            graph[road[1] - 1].add(new Integer[]{road[0] - 1, road[2]});
        }

        boolean[] visited = new boolean[n];
        int res = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (Integer[] neighbor : graph[node]) {
                res = Math.min(res, neighbor[1]);
                if (!visited[neighbor[0]]) {
                    queue.offer(neighbor[0]);
                    visited[neighbor[0]] = true;
                }
            }
        }

        return res;
    }
}
