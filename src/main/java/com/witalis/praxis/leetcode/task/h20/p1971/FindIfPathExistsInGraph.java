package com.witalis.praxis.leetcode.task.h20.p1971;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1971.option.*;
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
    id = 1971,
    description = "Find if Path Exists in Graph",
    difficulty = TaskDifficulty.EASY,
    tags = {GRAPH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND}
)
public class FindIfPathExistsInGraph extends LeetCodeTask<Boolean> {
    public static final int LEN = 200_000;

    private int number;
    private int[][] edges;
    private int source;
    private int destination;

    public static final String INFORMATION = """

        Description:
            There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
                The edges in the graph are represented as a 2D integer array edges,
                where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
                Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

            You want to determine if there is a valid path that exists from vertex source to vertex destination.

            Given edges and the integers n, source, and destination,
                return true if there is a valid path from source to destination, or false otherwise.

        Example:
            Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
            Output: true
            Explanation: There are two paths from vertex 0 to vertex 2:
                - 0 -> 1 -> 2
                - 0 -> 2""";

    public FindIfPathExistsInGraph(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        int[] frequency = new int[number];
        int len = random.nextInt(1, LEN + 1);
        List<int[]> vertexes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int one = random.nextInt(0, number);
            int two = random.nextInt(0, number);
            if (frequency[one] < 2 && frequency[two] < 2) {
                vertexes.add(new int[] {one, two});
                frequency[one]++;
                frequency[two]++;
            }
        }
        this.edges = vertexes.toArray(new int[0][]);
        this.source = random.nextInt(0, number);
        this.destination = random.nextInt(0, number);

        log.info("Number N: {}", number);
        log.info("Edges: {}", Arrays.deepToString(edges));
        log.info("Source: {}", source);
        log.info("Destination: {}", destination);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 26660 ms
    @Override
    protected Boolean original() {
        var original = new Original(number, edges, source, destination);
        return original.process();
    }

    // time = 25036 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number, edges, source, destination);
        return practice.process();
    }

    // time = 37758 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number, edges, source, destination);
        return solution.process();
    }
}
