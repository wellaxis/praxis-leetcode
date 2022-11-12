package com.witalis.praxis.leetcode.task.h4.p322;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p322.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 322,
    description = "Coin Change",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, BREADTH_FIRST_SEARCH}
)
public class CoinChange extends LeetCodeTask<Integer> {
    public static final int LEN = 12;
    public static final int VALUE = 10_000;
    private int[] coins;
    private int amount;

    public static final String INFORMATION = """

        Description:
            You are given an integer array coins representing coins of different denominations
                and an integer amount representing a total amount of money.

            Return the fewest number of coins that you need to make up that amount.
                If that amount of money cannot be made up by any combination of the coins, return -1.

            You may assume that you have an infinite number of each kind of coin.

        Example:
            Input: coins = [1,2,5], amount = 11
            Output: 3
            Explanation: 11 = 5 + 5 + 1""";

    public CoinChange(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.coins = random.ints(
            random.nextInt(1, LEN + 1),
            1, 10
        ).toArray();
        this.amount = random.nextInt(0, VALUE + 1);

        log.info("Coins are {}", Arrays.toString(coins));
        log.info("Amount is {}", amount);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1044 ms
    @Override
    protected Integer original() {
        var original = new Original(coins, amount);
        return original.process();
    }

    // time = 885 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(coins, amount);
        return practice.process();
    }

    // time = 736 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(coins, amount);
        return solution.process();
    }
}
