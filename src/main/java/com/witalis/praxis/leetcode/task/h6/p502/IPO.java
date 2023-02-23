package com.witalis.praxis.leetcode.task.h6.p502;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p502.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 502,
    description = "IPO",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, GREEDY, SORTING, HEAP}
)
public class IPO extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;
    public static final int SIZE = 100_000;
    public static final int COST = 10_000;

    private int projects;
    private int capital;
    private int[] profits;
    private int[] capitals;

    public static final String INFORMATION = """

        Description:
            Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
                LeetCode would like to work on some projects to increase its capital before the IPO.
                Since it has limited resources, it can only finish at most k distinct projects before the IPO.
                Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

            You are given n projects where the ith project has a pure profit profits[i]
                and a minimum capital of capital[i] is needed to start it.

            Initially, you have w capital. When you finish a project,
                you will obtain its pure profit and the profit will be added to your total capital.

            Pick a list of at most k distinct projects from given projects to maximize your final capital,
                and return the final maximized capital.

            The answer is guaranteed to fit in a 32-bit signed integer.

        Example:
            Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
            Output: 4
            Explanation: Since your initial capital is 0, you can only start the project indexed 0.
                After finishing it you will obtain profit 1 and your capital becomes 1.
                With capital 1, you can either start the project indexed 1 or the project indexed 2.
                Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
                Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.""";

    public IPO(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.projects = random.nextInt(1, LEN + 1);
        this.capital = random.nextInt(0, VALUE + 1);

        int len = random.nextInt(1, LEN + 1);
        this.profits = random.ints(
            len, 0, COST + 1
        ).toArray();
        this.capitals = random.ints(
            len, 0, VALUE + 1
        ).toArray();

        log.info("Projects: {}", projects);
        log.info("Capital: {}", capital);
        log.info("Profits: {}", Arrays.toString(profits));
        log.info("Capitals: {}", Arrays.toString(capitals));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 88711 ms
    @Override
    protected Integer original() {
        var original = new Original(projects, capital, profits, capitals);
        return original.process();
    }

    // time = 81921 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(projects, capital, profits, capitals);
        return practice.process();
    }

    // time = 60470 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(projects, capital, profits, capitals);
        return solution.process();
    }
}
