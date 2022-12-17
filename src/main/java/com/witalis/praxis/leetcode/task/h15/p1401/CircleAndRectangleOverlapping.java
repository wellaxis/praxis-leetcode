package com.witalis.praxis.leetcode.task.h15.p1401;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1401.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1401,
    description = "Circle and Rectangle Overlapping",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, GEOMETRY}
)
public class CircleAndRectangleOverlapping extends LeetCodeTask<Boolean> {
    public static final int VALUE = 10_000;
    public static final int RADIUS = 2_000;

    private int circleRadius;
    private int circleXCenter;
    private int circleYCenter;
    private int rectangleX1;
    private int rectangleY1;
    private int rectangleX2;
    private int rectangleY2;

    public static final String INFORMATION = """

        Description:
            You are given a circle represented as (radius, xCenter, yCenter)
                and an axis-aligned rectangle represented as (x1, y1, x2, y2),
                where (x1, y1) are the coordinates of the bottom-left corner,
                and (x2, y2) are the coordinates of the top-right corner of the rectangle.

            Return true if the circle and rectangle are overlapped otherwise return false.
                In other words, check if there is any point (xi, yi) that belongs to the circle and the rectangle at the same time.

        Example:
            Input: radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
            Output: true""";

    public CircleAndRectangleOverlapping(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.circleRadius = random.nextInt(1, RADIUS + 1);
        this.circleXCenter = random.nextInt(-VALUE, VALUE + 1);
        this.circleYCenter = random.nextInt(-VALUE, VALUE + 1);

        this.rectangleX1 = random.nextInt(-VALUE, VALUE);
        this.rectangleX2 = random.nextInt(rectangleX1 + 1, VALUE + 1);
        this.rectangleY1 = random.nextInt(-VALUE, VALUE);
        this.rectangleY2 = random.nextInt(rectangleY1 + 1, VALUE + 1);

        log.info("Circle: center({}, {}), radius {}", circleXCenter, circleYCenter, circleRadius);
        log.info("Rectangle: bottom-left corner({}, {}), top-right corner({}, {})", rectangleX1, rectangleY1, rectangleX2, rectangleY2);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2041 ms
    @Override
    protected Boolean original() {
        var original = new Original(circleRadius, circleXCenter, circleYCenter, rectangleX1, rectangleY1, rectangleX2, rectangleY2);
        return original.process();
    }

    // time = 3025 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(circleRadius, circleXCenter, circleYCenter, rectangleX1, rectangleY1, rectangleX2, rectangleY2);
        return practice.process();
    }

    // time = 1100 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(circleRadius, circleXCenter, circleYCenter, rectangleX1, rectangleY1, rectangleX2, rectangleY2);
        return solution.process();
    }
}
