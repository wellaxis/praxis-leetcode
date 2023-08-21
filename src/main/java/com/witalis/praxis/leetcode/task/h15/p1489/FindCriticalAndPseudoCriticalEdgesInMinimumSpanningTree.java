package com.witalis.praxis.leetcode.task.h15.p1489;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1489.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1489,
    description = "Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree",
    difficulty = TaskDifficulty.HARD,
    tags = {GRAPH, UNION_FIND, SORTING, MINIMUM_SPANNING_TREE, STRONGLY_CONNECTED_COMPONENT}
)
public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 100;
    public static final int VALUE = 1_000;

    private int vertices;
    private int[][] edges;

    public static final String INFORMATION = """

        Description:
            Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1,
                and an array edges where edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi.
                A minimum spanning tree (MST) is a subset of the graph's edges that connects all vertices
                without cycles and with the minimum possible total edge weight.

            Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST).
                An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge.
                On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.

            Note that you can return the indices of the edges in any order.

        Example:
            Input: n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
            Output: [[0,1],[2,3,4,5]]
            Explanation: The figure above describes the graph.""";

    public FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.vertices = random.nextInt(2, LEN + 1);

        Set<String> pairs = new HashSet<>();
        List<int[]> edgeList = new ArrayList<>();
        int size = random.nextInt(1, Math.min(200, vertices * (vertices - 1) / 2));
        for (int i = 0; i < size; i++) {
            int b = random.nextInt(0, vertices);
            int a = random.nextInt(0, b);
            if (a != b && !pairs.contains(a + "-" + b)) {
                edgeList.add(
                    new int[] {a, b, random.nextInt(1, VALUE + 1)}
                );
                pairs.add(a + "-" + b);
            }
        }
        this.edges = new int[edgeList.size()][3];
        for (int i = 0; i < edgeList.size(); i++) {
            edges[i] = edgeList.get(i);
        }

        log.info("Vertices: {}", vertices);
        log.info("Edges: {}", Arrays.deepToString(edges));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7850 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(vertices, edges);
        return original.process();
    }

    // time = 6635 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(vertices, edges);
        return practice.process();
    }

    // time = 4359 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(vertices, edges);
        return solution.process();
    }
}
