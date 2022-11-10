package com.witalis.praxis.leetcode.task.h13.p1232;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1232.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1232,
    description = "Check If It Is a Straight Line",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GEOMETRY}
)
public class CheckIfItIsStraightLine extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    public static final int VALUE = 10_000;
    private int[][] coordinates;

    public static final String INFORMATION = """

        Description:
            You are given an array coordinates, coordinates[i] = [x, y],
                where [x, y] represents the coordinate of a point.
                Check if these points make a straight line in the XY plane.

        Example:
            Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
            Output: true""";

    public CheckIfItIsStraightLine(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        this.coordinates = new int[len][2];
        for (int i = 0; i < len; i++) {
            coordinates[i] = new int[] {
                random.nextInt(-VALUE, VALUE + 1),
                random.nextInt(-VALUE, VALUE + 1)
            };
        }

        var builder = new StringBuilder();
        for (int[] coordinate: coordinates) {
            builder.append(Arrays.toString(coordinate)).append(' ');
        }
        log.info("Coordinates are {}", builder);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // dfs, time = 496 ms
    @Override
    protected Boolean original() {
        var original = new Original(coordinates);
        return original.process();
    }

    // dfs, time = 464 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(coordinates);
        return practice.process();
    }

    // bfs, time = 487 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(coordinates);
        return solution.process();
    }
}
