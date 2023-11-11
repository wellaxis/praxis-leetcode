package com.witalis.praxis.leetcode.task.h27.p2642.option;

import com.witalis.praxis.leetcode.task.h27.p2642.content.GraphRecord;
import com.witalis.praxis.leetcode.task.h27.p2642.content.IShortestGraphPathCalculator;
import com.witalis.praxis.leetcode.task.h27.p2642.content.ShortestGraphPathCalculatorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2642
 * Name: Design Graph With Shortest Path Calculator
 * URL: <a href="https://leetcode.com/problems/design-graph-with-shortest-path-calculator/">Design Graph With Shortest Path Calculator</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Object>> operations;

    // Floyd–Warshall algorithm
    public class Graph implements IShortestGraphPathCalculator {
        public static final int MAX_VALUE = 500_000_000;

        private int n;
        private int[][] distance;

        public Graph(int n, int[][] edges) {
            this.n = n;
            this.distance = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = MAX_VALUE;
                }
                distance[i][i] = 0;
            }

            for (int[] edge : edges) {
                distance[edge[0]][edge[1]] = edge[2];
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        distance[i][j] = Math.min(
                            distance[i][j],
                            distance[i][k] + distance[k][j]
                        );
                    }
                }
            }
        }

        @Override
        public void addEdge(int[] edge) {
            if (distance[edge[0]][edge[1]] <= edge[2]) {
                return;
            }
            distance[edge[0]][edge[1]] = edge[2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(
                        distance[i][j],
                        distance[i][edge[0]] + edge[2] + distance[edge[1]][j]
                    );
                }
            }
        }

        @Override
        public int shortestPath(int node1, int node2) {
            if (distance[node1][node2] == MAX_VALUE) {
                return -1;
            }

            return distance[node1][node2];
        }
    }

    public List<Integer> process() {
        GraphRecord graph = (GraphRecord) operations.get(0).getValue();
        return ShortestGraphPathCalculatorHandler.process(operations, new Graph(graph.nodes(), graph.edges()));
    }
}
