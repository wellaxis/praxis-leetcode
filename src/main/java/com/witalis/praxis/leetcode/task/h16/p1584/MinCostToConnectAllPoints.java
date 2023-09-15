package com.witalis.praxis.leetcode.task.h16.p1584;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1584.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1584,
    description = "Min Cost to Connect All Points",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, UNION_FIND, GRAPH, MINIMUM_SPANNING_TREE}
)
public class MinCostToConnectAllPoints extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000_000;

    private int[][] points;

    public static final String INFORMATION = """

        Description:
            You are given an array points representing integer coordinates of some points on a 2D-plane,
                where points[i] = [xi, yi].

            The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them:
                |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

            Return the minimum cost to make all points connected.
                All points are connected if there is exactly one simple path between any two points.

        Example:
            Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
            Output: 20
            Explanation:
                We can connect the points as shown above to get the minimum cost of 20.
                Notice that there is a unique path between every pair of points.""";

    public MinCostToConnectAllPoints(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(1, LEN + 1);
        this.points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i] = new int[] {
                random.nextInt(-VALUE, VALUE + 1),
                random.nextInt(-VALUE, VALUE + 1)
            };
        }

        log.info("Edges: {}", Arrays.deepToString(points));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 10944 ms
    @Override
    protected Integer original() {
        var original = new Original(points);
        return original.process();
    }

    // time = 10803 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(points);
        return practice.process();
    }

    // time = 15324 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(points);
        return solution.process();
    }
}
