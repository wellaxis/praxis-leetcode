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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Object>> operations;

    record Pair(int node1, int node2) {}

    // Dijkstra's Algorithm
    public class Graph implements IShortestGraphPathCalculator {
        private List<List<Pair>> pairs;

        public Graph(int n, int[][] edges) {
            this.pairs = new ArrayList<>();
            for (int i = 0; i < n; i++)
                pairs.add(new ArrayList<>());
            for (int[] e : edges)
                pairs.get(e[0]).add(new Pair(e[1], e[2]));
        }

        @Override
        public void addEdge(int[] edge) {
            pairs.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        @Override
        public int shortestPath(int node1, int node2) {
            final int n = pairs.size();

            Queue<List<Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));

            int[] costs = new int[n];
            Arrays.fill(costs, Integer.MAX_VALUE);
            costs[node1] = 0;
            heap.offer(Arrays.asList(0, node1));

            while (!heap.isEmpty()) {
                var item = heap.poll();
                int itemCost = item.get(0);
                int itemNode = item.get(1);

                if (itemCost > costs[itemNode]) {
                    continue;
                }
                if (itemNode == node2) {
                    return itemCost;
                }
                for (var pair : pairs.get(itemNode)) {
                    int node = pair.node1();
                    int cost = pair.node2();
                    int newCost = itemCost + cost;

                    if (newCost < costs[node]) {
                        costs[node] = newCost;
                        heap.offer(Arrays.asList(newCost, node));
                    }
                }
            }

            return -1;
        }
    }

    public List<Integer> process() {
        GraphRecord graph = (GraphRecord) operations.get(0).getValue();
        return ShortestGraphPathCalculatorHandler.process(operations, new Graph(graph.nodes(), graph.edges()));
    }
}
