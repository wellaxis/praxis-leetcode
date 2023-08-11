package com.witalis.praxis.leetcode.task.h6.p518;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p518.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 518,
    description = "Coin Change II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class CoinChangeII extends LeetCodeTask<Integer> {
    public static final int LEN = 300;
    public static final int VALUE = 5_000;

    private int amount;
    private int[] coins;

    public static final String INFORMATION = """

        Description:
            You are given an integer array coins representing coins of different denominations
                and an integer amount representing a total amount of money.

            Return the number of combinations that make up that amount.
                If that amount of money cannot be made up by any combination of the coins, return 0.

            You may assume that you have an infinite number of each kind of coin.

            The answer is guaranteed to fit into a signed 32-bit integer.

        Example:
            Input: amount = 5, coins = [1,2,5]
            Output: 4
            Explanation: there are four ways to make up the amount:
                5=5
                5=2+2+1
                5=2+1+1+1
                5=1+1+1+1+1""";

    public CoinChangeII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.coins = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).distinct().toArray();
        this.amount = random.nextInt(0, VALUE + 1);

        log.info("Amount: {}", amount);
        log.info("Coins: {}", Arrays.toString(coins));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 8374 ms
    @Override
    protected Integer original() {
        var original = new Original(amount, coins.clone());
        return original.process();
    }

    // time = 7751 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(amount, coins.clone());
        return practice.process();
    }

    // time = 1557 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(amount, coins.clone());
        return solution.process();
    }
}
