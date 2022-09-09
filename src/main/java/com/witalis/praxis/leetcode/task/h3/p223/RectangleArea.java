package com.witalis.praxis.leetcode.task.h3.p223;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p223.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 223,
    description = "Rectangle Area",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, GEOMETRY}
)
public class RectangleArea extends LeetCodeTask<Integer> {
    public static final int VALUE = 10_000;
    private int ax1;
    private int ay1;
    private int ax2;
    private int ay2;
    private int bx1;
    private int by1;
    private int bx2;
    private int by2;

    public static final String INFORMATION = """

        Given the coordinates of two rectilinear rectangles in a 2D plane,
            return the total area covered by the two rectangles.

        The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).

        The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

        Example:
            Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
            Output: 45""";

    public RectangleArea(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.ax1 = generate(-VALUE);
        this.ay1 = generate(-VALUE);
        this.ax2 = generate(ax1);
        this.ay2 = generate(ay1);
        this.bx1 = generate(-VALUE);
        this.by1 = generate(-VALUE);
        this.bx2 = generate(bx1);
        this.by2 = generate(by1);

        log.info("Rectangle N1: ({},{}) x ({},{})", ax1, ay1, ax2, ay2);
        log.info("Rectangle N2: ({},{}) x ({},{})", bx1, by1, bx2, by2);
    }

    private static int generate(int border) {
        return ThreadLocalRandom.current().nextInt(border, VALUE + 1);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 574 ms
    @Override
    protected Integer original() {
        var original = new Original(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        return original.process();
    }

    // time = 513 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        return practice.process();
    }

    // time = 479 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        return solution.process();
    }
}
