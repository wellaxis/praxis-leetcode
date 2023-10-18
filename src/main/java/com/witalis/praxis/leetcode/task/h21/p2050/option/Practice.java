package com.witalis.praxis.leetcode.task.h21.p2050.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2050
 * Name: Parallel Courses III
 * URL: <a href="https://leetcode.com/problems/parallel-courses-iii/">Parallel Courses III</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int size;
    private int[][] relations;
    private int[] times;

    public Integer process() {
        return minimumTime(size, relations, times);
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        if (n <= 0 || relations == null || time == null) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());

        int[] indegrees = new int[n];
        for (int[] edge : relations) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            indegrees[edge[1] - 1]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] maxTimes = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) queue.add(i);

            maxTimes[i] = time[i];
        }

        int node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            for (int neighbour : graph.get(node)) {
                maxTimes[neighbour] = Math.max(maxTimes[neighbour], maxTimes[node] + time[neighbour]);
                indegrees[neighbour]--;
                if (indegrees[neighbour] == 0) queue.add(neighbour);
            }
        }

        int minimumTime = 0;
        for (node = 0; node < n; node++)
            minimumTime = Math.max(minimumTime, maxTimes[node]);

        return minimumTime;
    }
}
