package com.witalis.praxis.leetcode.task.h9.p802;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p802.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 802,
    description = "Find Eventual Safe States",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH, TOPOLOGICAL_SORT, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class FindEventualSafeStates extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    private int[][] graph;

    public static final String INFORMATION = """

        There is a directed graph of n nodes with each node labeled from 0 to n - 1.
            The graph is represented by a 0-indexed 2D integer array graph where
            graph[i] is an integer array of nodes adjacent to node i,
            meaning there is an edge from node i to each node in graph[i].

        A node is a terminal node if there are no outgoing edges.
            A node is a safe node if every possible path starting from that node leads to a terminal node.

        Return an array containing all the safe nodes of the graph.
            The answer should be sorted in ascending order.

        Example:
            Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
            Output: [2,4,5,6]
            Explanation: The given graph is shown above.
                Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
                Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.""";

    public FindEventualSafeStates(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.graph = generate();

        log.info("Graph[n = {}]:", graph.length);
        printGraph(graph);
    }

    private static int[][] generate() {
        var random = ThreadLocalRandom.current();

        int number = random.nextInt(1, LEN + 1);

        int[][] graph = new int[number][];
        for (int i = 0; i < number; i++) {
            int len = random.nextInt(0, number + 1);
            int[] nodes = new int[len];
            for (int j = 0; j < len; j++) {
                nodes[j] = random.nextInt(0, number);
            }
            graph[i] = Arrays.stream(nodes).distinct().sorted().toArray();
        }
        return graph;
    }

    private static void printGraph(int[][] graph) {
        var format = "%" + String.valueOf(1000).length() + "d";

        for (int[] row : graph) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
        }
        log.info("Graph [{}] has been generated successfully.", graph.length);
    }

    private static int[][] cloneGraph(int[][] graph) {
        if (graph == null) return new int[0][0];

        return Arrays.stream(graph)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4050 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(graph);
        return original.process();
    }

    // time = 3490 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(graph);
        return practice.process();
    }

    // time = 1355 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(graph);
        return solution.process();
    }
}
