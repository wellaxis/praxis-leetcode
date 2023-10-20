package com.witalis.praxis.leetcode.task.h11.p1025;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1025.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1025,
    description = "Divisor Game",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, DYNAMIC_PROGRAMMING, BRAINTEASER, GAME_THEORY}
)
public class DivisorGame extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;

    private int number;

    public static final String INFORMATION = """

        Description:
            Alice and Bob take turns playing a game, with Alice starting first.

            Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
                * Choosing any x with 0 < x < n and n % x == 0.
                * Replacing the number n on the chalkboard with n - x.

            Also, if a player cannot make a move, they lose the game.

            Return true if and only if Alice wins the game, assuming both players play optimally.

        Example:
            Input: n = 2
            Output: true
            Explanation: Alice chooses 1, and Bob has no more moves.""";

    public DivisorGame(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        log.info("Number 'n': {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1840 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 1365 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 491 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
