package com.witalis.praxis.leetcode.task.h17.p1697;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1697.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1697,
    description = "Checking Existence of Edge Length Limited Paths",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, UNION_FIND, GRAPH, SORTING}
)
public class CheckingExistenceOfEdgeLengthLimitedPaths extends LeetCodeTask<boolean[]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000_000;

    private int nodes;
    private int[][] edges;
    private int[][] queries;

    public static final String INFORMATION = """

        Description:
            An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes
                an edge between nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes.

            Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j]
                whether there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .

            Return a boolean array answer, where answer.length == queries.length
                and the j^th value of answer is true if there is a path for queries[j] is true, and false otherwise.

        Example:
            Input: n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
            Output: [false,true]
            Explanation: The above figure shows the given graph. Note that there are two overlapping edges between 0 and 1 with distances 2 and 16.
                For the first query, between 0 and 1 there is no path where each distance is less than 2, thus we return false for this query.
                For the second query, there is a path (0 -> 1 -> 2) of two edges with distances less than 5, thus we return true for this query.""";

    public CheckingExistenceOfEdgeLengthLimitedPaths(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.nodes = random.nextInt(2, LEN + 1);

        int edgesLen = random.nextInt(1, LEN + 1);
        this.edges = new int[edgesLen][3];
        for (int i = 0; i < edgesLen; i++) {
            edges[i] = new int[] {
                random.nextInt(0, nodes),
                random.nextInt(0, nodes),
                random.nextInt(1, VALUE + 1)
            };
        }

        int queriesLen = random.nextInt(1, LEN + 1);
        this.queries = new int[queriesLen][3];
        for (int i = 0; i < queriesLen; i++) {
            queries[i] = new int[] {
                random.nextInt(0, nodes),
                random.nextInt(0, nodes),
                random.nextInt(1, VALUE + 1)
            };
        }

        log.info("Nodes: {}", nodes);
        log.info("Edges: {}", Arrays.deepToString(edges));
        log.info("Queries: {}", Arrays.deepToString(queries));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 14677164 ms, time limit exceeded
    @Override
    protected boolean[] original() {
        var original = new Original(nodes, edges.clone(), queries.clone());
        return original.process();
    }

    // time = 8606 ms
    @Override
    protected boolean[] practice() {
        var practice = new Practice(nodes, edges.clone(), queries.clone());
        return practice.process();
    }

    // time = 4307 ms
    @Override
    protected boolean[] solution() {
        var solution = new Solution(nodes, edges.clone(), queries.clone());
        return solution.process();
    }
}
