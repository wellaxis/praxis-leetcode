package com.witalis.praxis.leetcode.task.h29.p2849;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h29.p2849.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2849,
    description = "Determine if a Cell Is Reachable at a Given Time",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH}
)
public class DetermineIfCellIsReachableAtGivenTime extends LeetCodeTask<Boolean> {
    public static final int VALUE = (int) 1e9;

    private int startX;
    private int startY;
    private int finishX;
    private int finishY;
    private int time;

    public static final String INFORMATION = """

        Description:
            You are given four integers sx, sy, fx, fy, and a non-negative integer t.

            In an infinite 2D grid, you start at the cell (sx, sy). Each second, you must move to any of its adjacent cells.

            Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.

            A cell's adjacent cells are the 8 cells around it that share at least one corner with it.
                You can visit the same cell several times.

        Example:
            Input: sx = 2, sy = 4, fx = 7, fy = 7, t = 6
            Output: true
            Explanation: Starting at cell (2, 4), we can reach cell (7, 7) in exactly 6 seconds
                by going through the cells depicted in the picture above.""";

    public DetermineIfCellIsReachableAtGivenTime(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.startX = random.nextInt(1, VALUE + 1);
        this.startY = random.nextInt(1, VALUE + 1);
        this.finishX = random.nextInt(1, VALUE + 1);
        this.finishY = random.nextInt(1, VALUE + 1);
        this.time = random.nextInt(0, VALUE + 1);

        log.info("Start X: {}", startX);
        log.info("Start Y: {}", startY);
        log.info("Finish X: {}", finishX);
        log.info("Finish Y: {}", finishY);
        log.info("Time T: {}", time);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 617 ms
    @Override
    protected Boolean original() {
        var original = new Original(startX, startY, finishX, finishY, time);
        return original.process();
    }

    // time = 610 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(startX, startY, finishX, finishY, time);
        return practice.process();
    }

    // time = 597 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(startX, startY, finishX, finishY, time);
        return solution.process();
    }
}
