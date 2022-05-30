package com.witalis.praxis.leetcode.task.h1.p52;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p52.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 52,
    description = "N-Queens II",
    difficulty = TaskDifficulty.HARD,
    tags = {BACKTRACKING}
)
public class NQueensII extends LeetCodeTask<Integer> {
    public static final int LEN = 9;
    private int number;

    public static final String INFORMATION = """

        The n-queens puzzle is the problem of placing n queens on
            an n x n chessboard such that no two queens attack each other.

        Given an integer n, return the number of distinct solutions to the n-queens puzzle.

        Example:
            Input: n = 4
            Output: 2
            Explanation: There are two distinct solutions to the 4-queens puzzle""";

    public NQueensII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);
        log.info("Number is: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6475 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 3460 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 1068 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
