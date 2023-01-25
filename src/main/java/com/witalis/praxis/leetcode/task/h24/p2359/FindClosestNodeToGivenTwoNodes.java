package com.witalis.praxis.leetcode.task.h24.p2359;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2359.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2359,
    description = "Find Closest Node to Given Two Nodes",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DEPTH_FIRST_SEARCH, GRAPH}
)
public class FindClosestNodeToGivenTwoNodes extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    private int[] edges;
    private int node1;
    private int node2;

    public static final String INFORMATION = """

        Description:
            You are given a directed graph of n nodes numbered from 0 to n - 1,
                where each node has at most one outgoing edge.

            The graph is represented with a given 0-indexed array edges of size n,
                indicating that there is a directed edge from node i to node edges[i].
                If there is no outgoing edge from i, then edges[i] == -1.

            You are also given two integers node1 and node2.

            Return the index of the node that can be reached from both node1 and node2,
                such that the maximum between the distance from node1 to that node,
                and from node2 to that node is minimized. If there are multiple answers,
                return the node with the smallest index, and if no possible answer exists, return -1.

            Note that edges may contain cycles.

        Example:
            Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
            Output: 2
            Explanation: The distance from node 0 to node 2 is 1, and the distance from node 1 to node 2 is 1.
                The maximum of those two distances is 1.
                It can be proven that we cannot get a node with a smaller maximum distance than 1, so we return node 2.""";

    public FindClosestNodeToGivenTwoNodes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        this.edges = random.ints(len, 0, LEN).toArray();
        for (int i = 0; i < len / 10; i++) {
            edges[random.nextInt(0, LEN)] = -1;
        }

        this.node1 = random.nextInt(0, LEN);
        this.node2 = random.nextInt(0, LEN);

        log.info("Edges: {}", Arrays.toString(edges));
        log.info("Node N1: {}", node1);
        log.info("Node N2: {}", node2);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5986 ms
    @Override
    protected Integer original() {
        var original = new Original(edges, node1, node2);
        return original.process();
    }

    // time = 4577 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(edges, node1, node2);
        return practice.process();
    }

    // time = 2900 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(edges, node1, node2);
        return solution.process();
    }
}
