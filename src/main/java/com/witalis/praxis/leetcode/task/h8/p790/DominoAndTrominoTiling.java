package com.witalis.praxis.leetcode.task.h8.p790;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p790.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 790,
    description = "Domino and Tromino Tiling",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING}
)
public class DominoAndTrominoTiling extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    private int number;

    public static final String INFORMATION = """

        Description:
            You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

            Given an integer n, return the number of ways to tile an 2 x n board.
                Since the answer may be very large, return it modulo 109 + 7.

            In a tiling, every square must be covered by a tile.
                Two tilings are different if and only if there are two 4-directionally adjacent cells on the board
                such that exactly one of the tilings has both squares occupied by a tile.

        Example:
            Input: n = 3
            Output: 5
            Explanation: The five different ways are show above.""";

    public DominoAndTrominoTiling(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5386 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 3583 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 2627 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
