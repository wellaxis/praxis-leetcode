package com.witalis.praxis.leetcode.task.h12.p1129.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1129
 * Name: Shortest Path with Alternating Colors
 * URL: <a href="https://leetcode.com/problems/shortest-path-with-alternating-colors/">Shortest Path with Alternating Colors</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Solution {
    private int number;
    private int[][] redEdges;
    private int[][] blueEdges;

    public int[] process() {
        return shortestAlternatingPaths(number, redEdges, blueEdges);
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        final int[] result = new int[n];

        final ArrayList<Integer>[] redGraph = new ArrayList[n];
        final ArrayList<Integer>[] blueGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }

        for (final int[] edge : redEdges) {
            redGraph[edge[0]].add(edge[1]);
        }
        for (final int[] edge : blueEdges) {
            blueGraph[edge[0]].add(edge[1]);
        }

        final Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[] { 0, 0 });
        bfs.offer(new int[] { 0, 1 });

        final int[][] distances = new int[n][2];
        for (int i = 0; i < n; i++) {
            distances[i][0] = Integer.MAX_VALUE;
            distances[i][1] = Integer.MAX_VALUE;
        }

        distances[0][0] = 0;
        distances[0][1] = 0;

        while (!bfs.isEmpty()) {
            final int[] node = bfs.poll();
            int i = node[0];
            int color = node[1];
            int distance = distances[i][color];
            ArrayList<Integer> nextNodes = color == 0 ? redGraph[i] : blueGraph[i];

            for (int j : nextNodes) {
                if (distances[j][1 - color] == Integer.MAX_VALUE) {
                    distances[j][1 - color] = distance + 1;
                    bfs.offer(new int[] { j, 1 - color });
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = Math.min(distances[i][0], distances[i][1]);
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }

        return result;
    }
}
