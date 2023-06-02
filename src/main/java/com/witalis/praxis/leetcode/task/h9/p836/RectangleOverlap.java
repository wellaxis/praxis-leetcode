package com.witalis.praxis.leetcode.task.h9.p836;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p836.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 836,
    description = "Rectangle Overlap",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, GEOMETRY}
)
public class RectangleOverlap extends LeetCodeTask<Boolean> {
    public static final int LEN = 4;
    public static final int VALUE = 1_000_000_000;

    private int[] rectangle1;
    private int[] rectangle2;

    public static final String INFORMATION = """

        Description:
            An axis-aligned rectangle is represented as a list [x1, y1, x2, y2],
                where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner.
                Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

            Two rectangles overlap if the area of their intersection is positive.
                To be clear, two rectangles that only touch at the corner or edges do not overlap.

            Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.

        Example:
            Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
            Output: true""";

    public RectangleOverlap(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.rectangle1 = new int[LEN];
        this.rectangle2 = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            rectangle1[i] = random.nextInt(-VALUE, VALUE + 1);
            rectangle2[i] = random.nextInt(-VALUE, VALUE + 1);
        }

        log.info("Rectangle #1: {}", Arrays.toString(rectangle1));
        log.info("Rectangle #2: {}", Arrays.toString(rectangle2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1224 ms
    @Override
    protected Boolean original() {
        var original = new Original(rectangle1, rectangle2);
        return original.process();
    }

    // time = 998 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(rectangle1, rectangle2);
        return practice.process();
    }

    // time = 440 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(rectangle1, rectangle2);
        return solution.process();
    }
}
