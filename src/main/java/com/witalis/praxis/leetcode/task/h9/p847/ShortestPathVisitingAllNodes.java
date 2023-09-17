package com.witalis.praxis.leetcode.task.h9.p847;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p847.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 847,
    description = "Shortest Path Visiting All Nodes",
    difficulty = TaskDifficulty.HARD,
    tags = {DYNAMIC_PROGRAMMING, BIT_MANIPULATION, BREADTH_FIRST_SEARCH, GRAPH, BITMASK}
)
public class ShortestPathVisitingAllNodes extends LeetCodeTask<Integer> {
    public static final int LEN = 12;

    private int[][] graph;

    public static final String INFORMATION = """

        Description:
            You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
                You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

            Return the length of the shortest path that visits every node.
                You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

        Example:
            Input: graph = [[1,2,3],[0],[0],[0]]
            Output: 4
            Explanation: One possible path is [1,0,2,0,3]""";

    public ShortestPathVisitingAllNodes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.graph = generate();

        log.info("Graph[n = {}]:", graph.length);
        printGraph(graph);
    }

    private static int[][] generate() {
        final var random = ThreadLocalRandom.current();

        int number = random.nextInt(1, LEN + 1);

        List<Set<Integer>> allNodes = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            allNodes.add(i, new HashSet<>());
        }
        for (int i = 0; i < number; i++) {
            int len = random.nextInt(0, number);
            Set<Integer> nodes = new HashSet<>();
            for (int j = 0; j < len; j++) {
                int node = random.nextInt(0, number);
                if (i == node) continue;
                nodes.add(node);
                allNodes.get(node).add(i);
            }
            List<Integer> list = new ArrayList<>(nodes);
            Collections.shuffle(list);
            allNodes.get(i).addAll(list);
        }

        int[][] graph = new int[number][];
        for (int i = 0; i < number; i++) {
            Set<Integer> set = allNodes.get(i);
            graph[i] = set.stream().toList().stream().mapToInt(Integer::intValue).toArray();
        }

        return graph;
    }

    private static void printGraph(int[][] graph) {
        var format = "%" + String.valueOf(10).length() + "d";

        for (int i = 0; i < graph.length; i++) {
            var row = graph[i];
            var builder = new StringBuilder();
            builder.append("[").append(String.format(format, i)).append("] => | ");
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

    // time = 9262 ms
    @Override
    protected Integer original() {
        var original = new Original(graph);
        return original.process();
    }

    // time = 9152 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(graph);
        return practice.process();
    }

    // time = 3922 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(graph);
        return solution.process();
    }
}
