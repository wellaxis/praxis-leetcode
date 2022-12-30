package com.witalis.praxis.leetcode.task.h8.p797;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p797.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 797,
    description = "All Paths From Source to Target",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {BACKTRACKING, GRAPH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class AllPathsFromSourceToTarget extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 15;
    private int[][] graph;

    public static final String INFORMATION = """

        Description:
            Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
                find all possible paths from node 0 to node n - 1 and return them in any order.

            The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
                (i.e., there is a directed edge from node i to node graph[i][j]).

        Example:
            Input: graph = [[1,2],[3],[3],[]]
            Output: [[0,1,3],[0,2,3]]
            Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.""";

    public AllPathsFromSourceToTarget(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        this.graph = new int[len][];

        List<Integer> nodes;
        for (int i = 0; i < len; i++) {
            nodes = new ArrayList<>();
            int count = random.nextInt(0, len + 1);
            while (count > 0) {
                int node = random.nextInt(0, len + 1);
                if (node == i) continue;

                nodes.add(node);
                count--;
            }
            graph[i] = nodes.stream().mapToInt(Integer::intValue).toArray();
        }

        log.info("Graph [DAG]: {}", Arrays.deepToString(graph));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 26660 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(graph);
        return original.process();
    }

    // time = 25036 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(graph);
        return practice.process();
    }

    // time = 37758 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(graph);
        return solution.process();
    }
}
