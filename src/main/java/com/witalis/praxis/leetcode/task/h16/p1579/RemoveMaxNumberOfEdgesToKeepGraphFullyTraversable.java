package com.witalis.praxis.leetcode.task.h16.p1579;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1579.option.*;
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
    id = 1579,
    description = "Remove Max Number of Edges to Keep Graph Fully Traversable",
    difficulty = TaskDifficulty.HARD,
    tags = {UNION_FIND, GRAPH}
)
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;

    private int nodes;
    private int[][] edges;

    public static final String INFORMATION = """

        Description:
            Alice and Bob have an undirected graph of n nodes and three types of edges:
                * Type 1: Can be traversed by Alice only.
                * Type 2: Can be traversed by Bob only.
                * Type 3: Can be traversed by both Alice and Bob.

            Given an array edges where edges[i] = [typei, ui, vi] represents
                a bidirectional edge of type typei between nodes ui and vi,
                find the maximum number of edges you can remove so that after removing the edges,
                the graph can still be fully traversed by both Alice and Bob.
                The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

            Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

        Example:
            Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
            Output: 2
            Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob.
                Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.""";

    public RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.nodes = random.nextInt(1, LEN + 1);

        final List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            for (int j = i + 1; j < nodes; j++) {
                for (int t = 1; t <= 3; t++) {
                    if (random.nextBoolean()) {
                        edgeList.add(new int[] {t, i, j});
                    }
                }
            }
        }
        this.edges = edgeList.toArray(new int[0][0]);

        log.info("Nodes: {}", nodes);
        log.info("Edges: {}", Arrays.deepToString(edges));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 22177 ms
    @Override
    protected Integer original() {
        var original = new Original(nodes, edges.clone());
        return original.process();
    }

    // time = 21841 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(nodes, edges.clone());
        return practice.process();
    }

    // time = 12710 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(nodes, edges.clone());
        return solution.process();
    }
}
