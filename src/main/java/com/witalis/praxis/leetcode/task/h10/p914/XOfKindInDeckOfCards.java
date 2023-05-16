package com.witalis.praxis.leetcode.task.h10.p914;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p914.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 914,
    description = "X of a Kind in a Deck of Cards",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, MATH, COUNTING, NUMBER_THEORY}
)
public class XOfKindInDeckOfCards extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array deck where deck[i] represents the number written on the i^th card.

            Partition the cards into one or more groups such that:
                * Each group has exactly x cards where x > 1, and
                * All the cards in one group have the same integer written on them.

            Return true if such partition is possible, or false otherwise.

        Example:
            Input: deck = [1,2,3,4,4,3,2,1]
            Output: true
            Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].""";

    public XOfKindInDeckOfCards(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE
        ).distinct().toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 17131 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1211 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 3040 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
