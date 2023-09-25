package com.witalis.praxis.leetcode.task.h11.p1037;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1037.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1037,
    description = "Valid Boomerang",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GEOMETRY}
)
public class ValidBoomerang extends LeetCodeTask<Boolean> {
    public static final int LEN = 3;
    public static final int VALUE = 100;

    private int[][] points;

    public static final String INFORMATION = """

        Description:
            Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane,
                return true if these points are a boomerang.

            A boomerang is a set of three points that are all distinct and not in a straight line.

        Example:
            Input: points = [[1,1],[2,3],[3,2]]
            Output: true""";

    public ValidBoomerang(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.points = new int[LEN][2];
        for (int i = 0; i < LEN; i++) {
            points[i] = new int[] {
                random.nextInt(0, VALUE + 1),
                random.nextInt(0, VALUE + 1)
            };
        }

        log.info("Points: {}", Arrays.deepToString(points));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 696 ms
    @Override
    protected Boolean original() {
        var original = new Original(points);
        return original.process();
    }

    // time = 668 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(points);
        return practice.process();
    }

    // time = 631 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(points);
        return solution.process();
    }
}
