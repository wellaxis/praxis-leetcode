package com.witalis.praxis.leetcode.task.h27.p2642;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h27.p2642.content.GraphRecord;
import com.witalis.praxis.leetcode.task.h27.p2642.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2642,
    description = "Design Graph With Shortest Path Calculator",
    difficulty = TaskDifficulty.HARD,
    tags = {GRAPH, DESIGN, HEAP, SHORTEST_PATH}
)
public class DesignGraphWithShortestPathCalculator extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 100;
    public static final int VALUE = 1_000_000;

    private List<AbstractMap.SimpleEntry<String, Object>> operations;

    public static final String INFORMATION = """

        Description:
            There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1.
                The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti]
                    meaning that there is an edge from fromi to toi with the cost edgeCosti.

            Implement the Graph class:
                * Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
                * addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost].
                  It is guaranteed that there is no edge between the two nodes before adding this one.
                * int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2.
                  If no path exists, return -1. The cost of a path is the sum of the costs of the edges in the path.

        Example:
            Input
                ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
                [[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
            Output
                [null, 6, -1, null, 6]
            Explanation
                Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
                g.shortestPath(3, 2); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
                g.shortestPath(0, 3); // return -1. There is no path from 0 to 3.
                g.addEdge([1, 3, 4]); // We add an edge from node 1 to node 3, and we get the second diagram above.
                g.shortestPath(0, 3); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.""";

    public DesignGraphWithShortestPathCalculator(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(1, LEN + 1);
        int len = random.nextInt(0, n * (n - 1));
        int[][] edges = new int[len][3];
        for (int i = 0; i < len; i++) {
            int node1 = random.nextInt(0, n);
            int node2 = random.nextInt(0, n);
            int cost = random.nextInt(1, VALUE + 1);

            edges[i] = new int[] {
                node1,
                node2,
                cost
            };
        }

        this.operations = new ArrayList<>(len);

        operations.add(new AbstractMap.SimpleEntry<>("Graph", new GraphRecord(n, edges)));

        for (int i = 0; i < LEN; i++) {
            int node1 = random.nextInt(0, n);
            int node2 = random.nextInt(0, n);
            int cost = random.nextInt(1, VALUE + 1);

            operations.add(new AbstractMap.SimpleEntry<>("shortestPath", new int[] {node1, node2}));
            operations.add(new AbstractMap.SimpleEntry<>("addEdge", new int[] {node1, node2, cost}));
        }

        log.info("Graph: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 23038 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 20664 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 12441 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
