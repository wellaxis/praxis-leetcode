package com.witalis.praxis.leetcode.task.h9.p812;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p812.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 812,
    description = "Largest Triangle Area",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GEOMETRY}
)
public class LargestTriangleArea extends LeetCodeTask<Double> {
    public static final int LEN = 50;
    public static final int VALUE = 50;

    private int[][] points;

    public static final String INFORMATION = """

        Description:
            Given an array of points on the X-Y plane points where points[i] = [xi, yi],
                return the area of the largest triangle that can be formed by any three different points.
                Answers within 10-5 of the actual answer will be accepted.

        Example:
            Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
            Output: 2.00000
            Explanation: The five points are shown in the above figure. The red triangle is the largest.""";

    public LargestTriangleArea(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(3, LEN + 1);

        this.points = new int[len][2];
        for (int i = 0; i < len; i++) {
            points[i][0] = random.nextInt(-VALUE, VALUE + 1);
            points[i][1] = random.nextInt(-VALUE, VALUE + 1);
        }

        log.info("Area[n = {}]: {}", len, Arrays.deepToString(points));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1673 ms
    @Override
    protected Double original() {
        var original = new Original(points);
        return original.process();
    }

    // time = 1528 ms
    @Override
    protected Double practice() {
        var practice = new Practice(points);
        return practice.process();
    }

    // time = 4820 ms
    @Override
    protected Double solution() {
        var solution = new Solution(points);
        return solution.process();
    }
}
