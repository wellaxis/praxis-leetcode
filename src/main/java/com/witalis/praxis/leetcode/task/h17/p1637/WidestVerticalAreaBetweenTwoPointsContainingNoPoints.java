package com.witalis.praxis.leetcode.task.h17.p1637;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1637.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1637,
    description = "Widest Vertical Area Between Two Points Containing No Points",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, SORTING}
)
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[][] points;

    public static final String INFORMATION = """

        Description:
            Given n points on a 2D plane where points[i] = [xi, yi].
                Return the widest vertical area between two points such that no points are inside the area.

            A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height).
                The widest vertical area is the one with the maximum width.

            Note that points on the edge of a vertical area are not considered included in the area.

        Example:
            Input: points = [[8,7],[9,9],[7,4],[9,7]]
            Output: 1
            Explanation: Both the red and the blue area are optimal.""";

    public WidestVerticalAreaBetweenTwoPointsContainingNoPoints(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(2, LEN + 1);
        this.points = new int[n][2];
        for (int i = 0; i < n; i++)
            points[i] = new int[] {
                random.nextInt(0, VALUE + 1),
                random.nextInt(0, VALUE + 1)
            };

        log.info("Points: {}", Arrays.deepToString(points));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 63013 ms
    @Override
    protected Integer original() {
        var original = new Original(points);
        return original.process();
    }

    // time = 49720 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(points);
        return practice.process();
    }

    // time = 31198 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(points);
        return solution.process();
    }
}
