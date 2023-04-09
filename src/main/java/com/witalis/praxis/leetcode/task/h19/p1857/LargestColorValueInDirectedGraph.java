package com.witalis.praxis.leetcode.task.h19.p1857;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1857.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1857,
    description = "Largest Color Value in a Directed Graph",
    difficulty = TaskDifficulty.HARD,
    tags = {HASH_TABLE, DYNAMIC_PROGRAMMING, GRAPH, TOPOLOGICAL_SORT, MEMOIZATION, SORTING}
)
public class LargestColorValueInDirectedGraph extends LeetCodeTask<Integer> {
    public static final int LEN_COLORS = 100_000;
    public static final int LEN_EDGES = 100_000;

    private String colors;
    private int[][] edges;

    public static final String INFORMATION = """

        Description:
            There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

            You are given a string colors where colors[i] is a lowercase English letter
                representing the color of the ith node in this graph (0-indexed).
                You are also given a 2D array edges where edges[j] = [aj, bj] indicates that
                there is a directed edge from node aj to node bj.

            A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that
                there is a directed edge from xi to xi+1 for every 1 <= i < k.
                The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

            Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

        Example:
            Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
            Output: 3
            Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).""";

    public LargestColorValueInDirectedGraph(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var n = random.nextInt(1, LEN_COLORS + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.colors = builder.toString();

        var m = random.nextInt(1, LEN_EDGES + 1);
        var frequency = LEN_EDGES / m;
        final List<int[]> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            var count = random.nextInt(0, frequency + 1);
            Set<Integer> neighbours = new HashSet<>();
            for (int j = 0; j < count; j++) {
                neighbours.add(random.nextInt(1, n + 1));
            }
            for (int neighbour : neighbours) {
                nodes.add(new int[] {i, neighbour});
            }
        }
        this.edges = nodes.toArray(new int[0][]);

        log.info("Colors [n={}]: '{}'", colors.length(), colors);
        log.info("Edges [m={}]: {}", edges.length, Arrays.deepToString(edges));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 59709 ms
    @Override
    protected Integer original() {
        var original = new Original(colors, edges);
        return original.process();
    }

    // time = 30632 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(colors, edges);
        return practice.process();
    }

    // time = 23804 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(colors, edges);
        return solution.process();
    }
}
