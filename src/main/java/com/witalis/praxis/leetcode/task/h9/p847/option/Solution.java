package com.witalis.praxis.leetcode.task.h9.p847.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 847
 * Name: Shortest Path Visiting All Nodes
 * URL: <a href="https://leetcode.com/problems/shortest-path-visiting-all-nodes/">Shortest Path Visiting All Nodes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] graph;

    public Integer process() {
        return shortestPathLength(graph);
    }

    public int shortestPathLength(int[][] graph) {
        int noOfNodes = graph.length;

        int allMask = (1 << noOfNodes) - 1;
        boolean[][] visitedMaskAndNode = new boolean[noOfNodes][allMask + 1];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < noOfNodes; i++) {
            queue.add(new int[]{i, 1 << i, 0});
            visitedMaskAndNode[i][1 << i] = true;
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (node[1] == allMask) {
                return node[2];
            }
            for (int adjNode : graph[node[0]]) {
                int nextMask = node[1] | 1 << adjNode;
                if (!visitedMaskAndNode[adjNode][nextMask]) {
                    visitedMaskAndNode[adjNode][nextMask] = true;
                    queue.add(new int[]{adjNode, nextMask, node[2] + 1});
                }
            }
        }

        return -1;
    }
}
