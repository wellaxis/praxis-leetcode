package com.witalis.praxis.leetcode.task.h1.p62;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p62.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 62,
    description = "Unique Paths",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, DYNAMIC_PROGRAMMING, COMBINATORICS}
)
public class UniquePaths extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    private int m;
    private int n;

    public static final String INFORMATION = """

            There is a robot on an m x n grid.
                The robot is initially located at the top-left corner (i.e., grid[0][0]).
                The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
                The robot can only move either down or right at any point in time.

            Given the two integers m and n, return the number of possible unique paths
                that the robot can take to reach the bottom-right corner.

            The test cases are generated so that the answer will be less than or equal to 2 * 10^9.

            Example:
                Input: m = 3, n = 7
                Output: 28""";

    public UniquePaths(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.m = ThreadLocalRandom.current().nextInt(1, LEN + 1);
        this.n = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("M is {}, N is {}", m, n);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 516 ms
    @Override
    protected Integer original() {
        var original = new Original(m, n);
        return original.process();
    }

    // time = 375 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(m, n);
        return practice.process();
    }

    // time = 333 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(m, n);
        return solution.process();
    }
}
