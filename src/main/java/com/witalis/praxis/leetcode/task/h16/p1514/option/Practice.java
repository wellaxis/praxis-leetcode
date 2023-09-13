package com.witalis.praxis.leetcode.task.h16.p1514.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1514
 * Name: Path with Maximum Probability
 * URL: <a href="https://leetcode.com/problems/path-with-maximum-probability/">Path with Maximum Probability</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Practice {
    private int nodes;
    private int[][] edges;
    private double[] probabilities;
    private int start;
    private int end;

    public Double process() {
        return maxProbability(nodes, edges, probabilities, start, end);
    }

    record Pair(int node, double probability) {}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if (edges == null || succProb == null || n <= 0) return 0D;

        final List<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double probability = succProb[i];
            graph[u].add(new Pair(v, probability));
            graph[v].add(new Pair(u, probability));
        }

        final double[] probabilities = new double[n];
        Arrays.fill(probabilities, 0D);
        probabilities[start] = 1D;

        final Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Pair pair : graph[node]) {
                int neighbor = pair.node;
                double probability = pair.probability;

                double pathProbability = probabilities[node] * probability;
                if (pathProbability > probabilities[neighbor]) {
                    probabilities[neighbor] = pathProbability;
                    queue.add(neighbor);
                }
            }
        }

        return probabilities[end];
    }
}
