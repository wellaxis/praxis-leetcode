package com.witalis.praxis.leetcode.task.h1.p60;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p60.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 60,
    description = "Permutation Sequence",
    difficulty = TaskDifficulty.HARD,
    tags = {MATH, RECURSION}
)
public class PermutationSequence extends LeetCodeTask<String> {
    public static final int LEN = 9;
    private int number;
    private int position;

    public static final String INFORMATION = """

            The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

            By listing and labeling all of the permutations in order,
                we get the following sequence for n = 3:
                "123"
                "132"
                "213"
                "231"
                "312"
                "321"

            Given n and k, return the k^th permutation sequence.

            Example:
                Input: n = 3, k = 3
                Output: "213" """;

    public PermutationSequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.number = random.nextInt(1, LEN + 1);
        var factor = IntStream.rangeClosed(1, number).reduce(1, (int x, int y) -> x * y);
        this.position = random.nextInt(1, factor + 1);

        log.info("Number is {}", number);
        log.info("Position is {}", position);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 11268 ms, time limit exceeded
    @Override
    protected String original() {
        var original = new Original(number, position);
        return original.process();
    }

    // time = 716 ms
    @Override
    protected String practice() {
        var practice = new Practice(number, position);
        return practice.process();
    }

    // time = 511 ms
    @Override
    protected String solution() {
        var solution = new Solution(number, position);
        return solution.process();
    }
}
