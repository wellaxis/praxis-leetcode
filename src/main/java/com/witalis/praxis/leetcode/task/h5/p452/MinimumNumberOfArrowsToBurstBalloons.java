package com.witalis.praxis.leetcode.task.h5.p452;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p452.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 452,
    description = "Minimum Number of Arrows to Burst Balloons",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GREEDY, SORTING}
)
public class MinimumNumberOfArrowsToBurstBalloons extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    private int[][] points;

    public static final String INFORMATION = """

        Description:
            There are some spherical balloons taped onto a flat wall that represents the XY-plane.
                The balloons are represented as a 2D integer array points where points[i] = [x-start, x-end] denotes a balloon
                whose horizontal diameter stretches between x-start and x-end.
                You do not know the exact y-coordinates of the balloons.

            Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
                A balloon with x-start and x-end is burst by an arrow shot at x if x-start <= x <= x-end.
                There is no limit to the number of arrows that can be shot.
                A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

            Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

        Example:
            Input: points = [[10,16],[2,8],[1,6],[7,12]]
            Output: 2
            Explanation: The balloons can be burst by 2 arrows:
                - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
                - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].""";

    public MinimumNumberOfArrowsToBurstBalloons(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.points = new int[len][2];
        for (int i = 0; i < len; i++) {
            int p1 = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            int p2 = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            points[i] = new int[] {
                Math.min(p1, p2),
                Math.max(p1, p2)
            };
        }

        var builder = new StringBuilder("\n");
        for (int[] point : points) {
            builder.append(Arrays.toString(point)).append('\n');
        }

        log.info("Points [{}] is {}", len, builder);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 39933 ms
    @Override
    protected Integer original() {
        var original = new Original(points);
        return original.process();
    }

    // time = 18601 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(points);
        return practice.process();
    }

    // time = 51964 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(points);
        return solution.process();
    }
}
