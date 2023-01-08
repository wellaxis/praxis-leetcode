package com.witalis.praxis.leetcode.task.h2.p149;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p149.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 149,
    description = "Max Points on a Line",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE, MATH, GEOMETRY}
)
public class MaxPointsOnLine extends LeetCodeTask<Integer> {
    public static final int LEN = 300;
    public static final int VALUE = 10_000;
    private int[][] points;

    public static final String INFORMATION = """

        Description:
            Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
                return the maximum number of points that lie on the same straight line.

        Example:
            Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
            Output: 4""";

    public MaxPointsOnLine(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        Set<String> set = new HashSet<>();
        this.points = new int[len][];
        int count = 0;
        while (count < len) {
            int x = random.nextInt(-VALUE, VALUE + 1);
            int y = random.nextInt(-VALUE, VALUE + 1);
            String point = "[" + x + "," + y + "]";
            if (set.contains(point)) continue;
            set.add(point);
            points[count] = new int[] {x, y};
            count++;
        }

        log.info("Points: {}", Arrays.deepToString(points));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4089 ms
    @Override
    protected Integer original() {
        var original = new Original(points);
        return original.process();
    }

    // time = 3341 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(points);
        return practice.process();
    }

    // time = 6390 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(points);
        return solution.process();
    }
}
