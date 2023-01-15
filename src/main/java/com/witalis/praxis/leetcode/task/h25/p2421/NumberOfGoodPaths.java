package com.witalis.praxis.leetcode.task.h25.p2421;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2421.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2421,
    description = "Number of Good Paths",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, TREE, UNION_FIND, GRAPH}
)
public class NumberOfGoodPaths extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    public static final int VALUE = 100_000;

    private int[] values;
    private int[][] edges;

    public static final String INFORMATION = """

        Description:
            There is a tree (i.e. a connected, undirected graph with no cycles)
                consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.

            You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node.
                You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes
                that there exists an undirected edge connecting nodes ai and bi.

            A good path is a simple path that satisfies the following conditions:
                * The starting node and the ending node have the same value.
                * All nodes between the starting node and the ending node have values less than or equal to the starting node
                  (i.e. the starting node's value should be the maximum value along the path).

            Return the number of distinct good paths.

            Note that a path and its reverse are counted as the same path.
                For example, 0 -> 1 is considered to be the same as 1 -> 0.
                A single node is also considered as a valid path.

        Example:
            Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
            Output: 6
            Explanation: There are 5 good paths consisting of a single node.
                There is 1 additional good path: 1 -> 0 -> 2 -> 4.
                (The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
                Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].""";

    public NumberOfGoodPaths(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int number = random.nextInt(1, LEN + 1);

        this.values = random.ints(number, 1, VALUE + 1).toArray();

        this.edges = new int[number - 1][2];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(count);
        while (!queue.isEmpty() && count < number - 1) {
            int parent = queue.poll();
            int mode = random.nextInt(1, 4);
            for (int m = 0; m < mode; m++) {
                if (count < number - 1) {
                    edges[count] = new int[] {parent, ++count};
                    queue.offer(count);
                }
            }
        }

        log.info("Number N: {}", number);
        log.info("Values: {}", Arrays.toString(values));
        log.info("Edges: {}", Arrays.deepToString(edges));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3094848 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(values, edges);
        return original.process();
    }

    // time = 54096 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(values, edges);
        return practice.process();
    }

    // time = 53810 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(values, edges);
        return solution.process();
    }
}
