package com.witalis.praxis.leetcode.task.h5.p486;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p486.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 486,
    description = "Predict the Winner",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, DYNAMIC_PROGRAMMING, RECURSION, GAME_THEORY}
)
public class PredictWinner extends LeetCodeTask<Boolean> {
    public static final int LEN = 20;
    public static final int VALUE = 10_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

            Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0.
                At each turn, the player takes one of the numbers from either end of the array
                (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1.
                The player adds the chosen number to their score. The game ends when there are no more elements in the array.

            Return true if Player 1 can win the game. If the scores of both players are equal,
                then player 1 is still the winner, and you should also return true.
                You may assume that both players are playing optimally.

        Example:
            Input: nums = [1,5,233,7]
            Output: true
            Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
                Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.""";

    public PredictWinner(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 8816 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 4298 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1543 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
