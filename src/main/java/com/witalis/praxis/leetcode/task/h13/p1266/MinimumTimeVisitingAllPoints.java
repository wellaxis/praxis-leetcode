package com.witalis.praxis.leetcode.task.h13.p1266;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1266.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1266,
    description = "Minimum Time Visiting All Points",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GEOMETRY}
)
public class MinimumTimeVisitingAllPoints extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 1_000;

    private int[][] points;

    public static final String INFORMATION = """

        Description:
            On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi].
                Return the minimum time in seconds to visit all the points in the order given by points.

            You can move according to these rules:
                * In 1 second, you can either:
                    * move vertically by one unit,
                    * move horizontally by one unit, or
                    * move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
                * You have to visit the points in the same order as they appear in the array.
                * You are allowed to pass through points that appear later in the order, but these do not count as visits.

        Example:
            Input: points = [[1,1],[3,4],[-1,0]]
            Output: 7
            Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
                Time from [1,1] to [3,4] = 3 seconds
                Time from [3,4] to [-1,0] = 4 seconds
                Total time = 7 seconds""";

    public MinimumTimeVisitingAllPoints(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.points = new int[len][2];
        for (int i = 0; i < len; i++) {
            points[i] = new int[] {
                random.nextInt(-VALUE, VALUE + 1),
                random.nextInt(-VALUE, VALUE + 1)
            };
        }

        log.info("Points: {}", Arrays.deepToString(points));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3113 ms
    @Override
    protected Integer original() {
        var original = new Original(points);
        return original.process();
    }

    // time = 1122 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(points);
        return practice.process();
    }

    // time = 1105 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(points);
        return solution.process();
    }
}
