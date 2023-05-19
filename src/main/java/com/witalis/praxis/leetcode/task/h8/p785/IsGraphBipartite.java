package com.witalis.praxis.leetcode.task.h8.p785;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p785.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 785,
    description = "[Is Graph Bipartite?",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND}
)
public class IsGraphBipartite extends LeetCodeTask<Boolean> {
    public static final int LEN = 100;

    private int[][] graph;

    public static final String INFORMATION = """

        Description:
            There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
                You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
                More formally, for each v in graph[u], there is an undirected edge between node u and node v.

            The graph has the following properties:
                * There are no self-edges (graph[u] does not contain u).
                * There are no parallel edges (graph[u] does not contain duplicate values).
                * If v is in graph[u], then u is in graph[v] (the graph is undirected).
                * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.

            A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that
                every edge in the graph connects a node in set A and a node in set B.

            Return true if and only if it is bipartite.

        Example:
            Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
            Output: false
            Explanation: There is no way to partition the nodes into two independent sets such that
                every edge connects a node in one and a node in the other.""";

    public IsGraphBipartite(int id, String description, TaskRevision revision) {
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

    // time = 725 ms
    @Override
    protected Boolean original() {
        var original = new Original(graph);
        return original.process();
    }

    // time = 678 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(graph);
        return practice.process();
    }

    // time = 967 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(graph);
        return solution.process();
    }
}
