package com.witalis.praxis.leetcode.task.h15.p1444;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1444.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1444,
    description = "Number of Ways of Cutting a Pizza",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, MEMOIZATION, MATRIX}
)
public class NumberOfWaysOfCuttingPizza extends LeetCodeTask<Integer> {
    public static final int SIZE = 50;
    public static final int LEN = 10;

    private String[] pizza;
    private int pieces;

    public static final String INFORMATION = """

        Description:
            Given a rectangular pizza represented as a rows x cols matrix containing the following characters:
                'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts.

            For each cut you choose the direction: vertical or horizontal,
                then you choose a cut position at the cell boundary and cut the pizza into two pieces.
                If you cut the pizza vertically, give the left part of the pizza to a person.
                If you cut the pizza horizontally, give the upper part of the pizza to a person.
                Give the last piece of pizza to the last person.

            Return the number of ways of cutting the pizza such that each piece contains at least one apple.
                Since the answer can be a huge number, return this modulo 10^9 + 7.

        Example:
            Input: pizza = ["A..","AAA","..."], k = 3
            Output: 3
            Explanation: The figure above shows the three ways to cut the pizza. Note that pieces must contain at least one apple.""";

    public NumberOfWaysOfCuttingPizza(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int rows = random.nextInt(1, SIZE + 1);
        final int cols = random.nextInt(1, SIZE + 1);

        this.pizza = new String[rows];
        for (int row = 0; row < rows; row++) {
            var builder = new StringBuilder();
            for (int col = 0; col < cols; col++) {
                builder.append(random.nextBoolean() ? 'A' : '.');
            }
            pizza[row] = builder.toString();
        }

        this.pieces = random.nextInt(1, LEN + 1);

        log.info("Pizza: {}", Arrays.toString(pizza));
        log.info("Pieces: {}", pieces);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 955921 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(pizza, pieces);
        return original.process();
    }

    // time = 3712 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(pizza, pieces);
        return practice.process();
    }

    // time = 938 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(pizza, pieces);
        return solution.process();
    }
}
