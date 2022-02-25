package com.witalis.praxis.leetcode.task.h3.p292;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p292.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 292,
    description = "Nim Game",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, BRAINTEASER, GAME_THEORY}
)
public class NimGame extends LeetCodeTask<Boolean> {
    private int number;

    public static final String INFORMATION = """

        Description:
            You are playing the following Nim Game with your friend:
                * Initially, there is a heap of stones on the table.
                * You and your friend will alternate taking turns, and you go first.
                * On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
                * The one who removes the last stone is the winner.

            Given n, the number of stones in the heap,
                return true if you can win the game assuming both
                you and your friend play optimally, otherwise return false.

        Example:
            Input: n = 4
            Output: false
            Explanation: These are the possible outcomes:
                1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
                2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
                3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
            In all outcomes, your friend wins.""";

    public NimGame(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 346 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 335 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 386 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
