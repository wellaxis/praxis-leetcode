package com.witalis.praxis.leetcode.task.h24.p2316;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2316.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2316,
    description = "Count Unreachable Pairs of Nodes in an Undirected Graph",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, GRAPH}
)
public class CountUnreachablePairsOfNodesInUndirectedGraph extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;

    private int vertices;
    private int[][] edges;

    public static final String INFORMATION = """

        Description:
            You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1.
                You are given a 2D integer array edges where edges[i] = [ai, bi] denotes
                that there exists an undirected edge connecting nodes ai and bi.

            Return the number of pairs of different nodes that are unreachable from each other.

        Example:
            Input: n = 3, edges = [[0,1],[0,2],[1,2]]
            Output: 0
            Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.""";

    public CountUnreachablePairsOfNodesInUndirectedGraph(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.vertices = random.nextInt(1, LEN + 1);

        final int len = random.nextInt(0, 2 * LEN + 1);
        final List<int[]> allVertices = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < vertices; i++) {
            if (counter >= len) break;
            for (int j = i + 1; j < vertices; j++) {
                if (random.nextInt(0, vertices / 100) == 0) {
                    if (counter >= len) break;
                    allVertices.add(new int[]{i, j});
                    counter++;
                }
            }
        }
        Collections.shuffle(allVertices);
        this.edges = allVertices.toArray(int[][]::new);

        log.info("Vertices: {}", vertices);
        log.info("Edges: {}", Arrays.deepToString(edges));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 64934 ms
    @Override
    protected Long original() {
        var original = new Original(vertices, edges);
        return original.process();
    }

    // time = 48408 ms
    @Override
    protected Long practice() {
        var practice = new Practice(vertices, edges);
        return practice.process();
    }

    // time = 15389 ms
    @Override
    protected Long solution() {
        var solution = new Solution(vertices, edges);
        return solution.process();
    }
}
