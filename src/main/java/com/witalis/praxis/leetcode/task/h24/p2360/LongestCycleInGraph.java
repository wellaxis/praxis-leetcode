package com.witalis.praxis.leetcode.task.h24.p2360;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2360.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2360,
    description = "Longest Cycle in a Graph",
    difficulty = TaskDifficulty.HARD,
    tags = {DEPTH_FIRST_SEARCH, GRAPH, TOPOLOGICAL_SORT}
)
public class LongestCycleInGraph extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private int[] edges;

    public static final String INFORMATION = """

        Description:
            You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

            The graph is represented with a given 0-indexed array edges of size n,
                indicating that there is a directed edge from node i to node edges[i].
                If there is no outgoing edge from node i, then edges[i] == -1.

            Return the length of the longest cycle in the graph. If no cycle exists, return -1.

            A cycle is a path that starts and ends at the same node.

        Example:
            Input: edges = [3,3,4,2,3]
            Output: 3
            Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
            The length of this cycle is 3, so 3 is returned.""";

    public LongestCycleInGraph(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(2, LEN + 1);
        this.edges = new int[len];
        for (int i = 0; i < len; i++) {
            int node = random.nextInt(-1, len);
            edges[i] = node;
        }

        log.info("Edges: {}", Arrays.toString(edges));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 23638 ms
    @Override
    protected Integer original() {
        var original = new Original(edges);
        return original.process();
    }

    // time = 22756 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(edges);
        return practice.process();
    }

    // time = 2579 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(edges);
        return solution.process();
    }
}