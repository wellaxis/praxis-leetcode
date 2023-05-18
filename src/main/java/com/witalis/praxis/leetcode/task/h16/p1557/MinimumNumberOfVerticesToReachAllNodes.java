package com.witalis.praxis.leetcode.task.h16.p1557;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1557.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1557,
    description = "Minimum Number of Vertices to Reach All Nodes",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH}
)
public class MinimumNumberOfVerticesToReachAllNodes extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int nodes;
    private List<List<Integer>> edges;

    public static final String INFORMATION = """

        Description:
            Given a directed acyclic graph, with n vertices numbered from 0 to n-1,
                and an array edges where edges[i] = [from[i], to[i]] represents a directed edge from node from[i] to node to[i].

            Find the smallest set of vertices from which all nodes in the graph are reachable.
                It's guaranteed that a unique solution exists.

            Notice that you can return the vertices in any order.

        Example:
            Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
            Output: [0,2,3]
            Explanation: Notice that vertices 0, 3 and 2 are not reachable from any other node, so we must include them.
                Also any of these vertices can reach nodes 1 and 4.""";

    public MinimumNumberOfVerticesToReachAllNodes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.nodes = random.nextInt(2, LEN + 1);
        this.edges = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            for (int j = i + 1; j < nodes; j++) {
                if (random.nextInt(0, 3) == 0)
                    edges.add(List.of(i, j));
            }
        }

        log.info("Nodes: {}", nodes);
        log.info("Edges: {}", edges.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 350435 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(nodes, edges);
        return original.process();
    }

    // time = 342458 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(nodes, edges);
        return practice.process();
    }

    // time = 284731 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(nodes, edges);
        return solution.process();
    }
}
