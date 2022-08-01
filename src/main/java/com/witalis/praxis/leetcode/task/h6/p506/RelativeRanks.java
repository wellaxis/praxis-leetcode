package com.witalis.praxis.leetcode.task.h6.p506;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p506.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 506,
    description = "Relative Ranks",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING, HEAP}
)
public class RelativeRanks extends LeetCodeTask<String[]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000;
    private int[] score;

    public static final String INFORMATION = """

        You are given an integer array score of size n,
            where score[i] is the score of the ith athlete in a competition.
            All the scores are guaranteed to be unique.

        The athletes are placed based on their scores, where the 1st place athlete has the highest score,
            the 2nd place athlete has the 2nd highest score, and so on.
            The placement of each athlete determines their rank:
            * The 1st place athlete's rank is "Gold Medal".
            * The 2nd place athlete's rank is "Silver Medal".
            * The 3rd place athlete's rank is "Bronze Medal".
            * For the 4th place to the nth place athlete, their rank is their placement number
              (i.e., the xth place athlete's rank is "x").

        Return an array answer of size n where answer[i] is the rank of the ith athlete.

        Example:
            Input: score = [10,3,8,9,4]
            Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
            Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].""";

    public RelativeRanks(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.score = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).distinct().toArray();

        log.info("Scores are {}", Arrays.toString(score));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6283 ms
    @Override
    protected String[] original() {
        var original = new Original(score.clone());
        return original.process();
    }

    // time = 2341 ms
    @Override
    protected String[] practice() {
        var practice = new Practice(score.clone());
        return practice.process();
    }

    // time = 6271 ms
    @Override
    protected String[] solution() {
        var solution = new Solution(score.clone());
        return solution.process();
    }
}
