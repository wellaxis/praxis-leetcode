package com.witalis.praxis.leetcode.task.h16.p1514.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1514
 * Name: Path with Maximum Probability
 * URL: <a href="https://leetcode.com/problems/path-with-maximum-probability/">Path with Maximum Probability</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int nodes;
    private int[][] edges;
    private double[] probabilities;
    private int start;
    private int end;

    public Double process() {
        return maxProbability(nodes, edges, probabilities, start, end);
    }

    // Bellman-Ford algorithm
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }
            if (!hasUpdate) {
                break;
            }
        }

        return maxProb[end];
    }
}
