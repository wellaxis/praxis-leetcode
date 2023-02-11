package com.witalis.praxis.leetcode.task.h12.p1129;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1129.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1129,
    description = "Shortest Path with Alternating Colors",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {BREADTH_FIRST_SEARCH, MATRIX}
)
public class ShortestPathWithAlternatingColors extends LeetCodeTask<int[]> {
    public static final int LEN = 100;
    public static final int SIZE = 400;

    private int number;
    private int[][] redEdges;
    private int[][] blueEdges;

    public static final String INFORMATION = """

        Description:
            You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1.
                Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

            You are given two arrays redEdges and blueEdges where:
                * redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
                * blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.

            Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x
                such that the edge colors alternate along the path, or -1 if such a path does not exist.

        Example:
            Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
            Output: [0,1,-1]""";

    public ShortestPathWithAlternatingColors(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);
        this.redEdges = generate(number);
        this.blueEdges = generate(number);

        log.info("Number N: {}", number);
        log.info("Red edges: {}", Arrays.deepToString(redEdges));
        log.info("Blue edges: {}", Arrays.deepToString(blueEdges));
    }

    private static int[][] generate(int nodes) {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(0, SIZE + 1);
        int[][] edges = new int[size][2];
        for (int i = 0; i < size; i++) {
            edges[i][0] = random.nextInt(0, nodes);
            edges[i][1] = random.nextInt(0, nodes);
        }

        return edges;
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        if (matrix == null) return new int[0][0];

        return Arrays.stream(matrix)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3222 ms
    @Override
    protected int[] original() {
        var original = new Original(number, redEdges, blueEdges);
        return original.process();
    }

    // time = 1321 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(number, redEdges, blueEdges);
        return practice.process();
    }

    // time = 643 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(number, redEdges, blueEdges);
        return solution.process();
    }
}
