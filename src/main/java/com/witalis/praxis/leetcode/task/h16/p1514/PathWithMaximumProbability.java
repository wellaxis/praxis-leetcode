package com.witalis.praxis.leetcode.task.h16.p1514;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1514.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1514,
    description = "Path with Maximum Probability",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GRAPH, HEAP, SHORTEST_PATH}
)
public class PathWithMaximumProbability extends LeetCodeTask<Double> {
    public static final int LEN = 2_000;
    public static final int VALUE = 1_000;

    private int nodes;
    private int[][] edges;
    private double[] probabilities;
    private int start;
    private int end;

    public static final String INFORMATION = """

        Description:
            You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list
                where edges[i] = [a, b] is an undirected edge connecting the nodes a and b
                with a probability of success of traversing that edge succProb[i].

            Given two nodes start and end, find the path with the maximum probability of success
                to go from start to end and return its success probability.

            If there is no path from start to end, return 0.
                Your answer will be accepted if it differs from the correct answer by at most 1e-5.

        Example:
            Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
            Output: 0.25000
            Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.""";

    public PathWithMaximumProbability(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.nodes = random.nextInt(2, VALUE + 1);

        record Pair (int node1, int node2) {}
        Set<Pair> cache = new HashSet<>();
        List<int[]> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            for (int j = i + 1; j < nodes; j++) {
                if (random.nextInt(0, 5) == 0) continue;
                if (cache.contains(new Pair(i, j)) || cache.contains(new Pair(j, i))) continue;

                Pair pair = random.nextBoolean() ? new Pair(i, j) : new Pair(j, i);
                graph.add(new int[] {pair.node1, pair.node2});
                cache.add(new Pair(i, j));
                cache.add(new Pair(j, i));
            }
        }
        this.edges = graph.toArray(int[][]::new);
        this.probabilities = random.doubles(edges.length, 0.0, 1.0).toArray();

        this.start = random.nextInt(0, nodes);
        this.end = random.nextInt(0, nodes);
        while (end == start) end = random.nextInt(0, nodes);

        log.info("Nodes: {}", nodes);
        log.info("Edges: {}", Arrays.deepToString(edges));
        log.info("Probabilities: {}", Arrays.toString(probabilities));
        log.info("Start: {}", start);
        log.info("End: {}", end);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 12873 ms
    @Override
    protected Double original() {
        var original = new Original(nodes, edges, probabilities, start, end);
        return original.process();
    }

    // time = 11046 ms
    @Override
    protected Double practice() {
        var practice = new Practice(nodes, edges, probabilities, start, end);
        return practice.process();
    }

    // time = 7449 ms
    @Override
    protected Double solution() {
        var solution = new Solution(nodes, edges, probabilities, start, end);
        return solution.process();
    }
}
