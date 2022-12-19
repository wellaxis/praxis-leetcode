package com.witalis.praxis.leetcode.task.h20.p1971.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1971
 * Name: Find if Path Exists in Graph
 * URL: <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">Find if Path Exists in Graph</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[][] edges;
    private int source;
    private int destination;

    public Boolean process() {
        return validPath(number, edges, source, destination);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // store all edges according to nodes in 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        // start from source node, add it to stack.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (currNode == destination) {
                return true;
            }
            // add all unvisited neighbors of the current node to stack' and mark it as visited.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    stack.push(nextNode);
                }
            }
        }

        return false;
    }
}
