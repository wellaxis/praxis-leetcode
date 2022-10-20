package com.witalis.praxis.leetcode.task.h4.p309;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p309.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 309,
    description = "Best Time to Buy and Sell Stock with Cooldown",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class BestTimeToBuyAndSellStockWithCooldown extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;
    public static final int VALUE = 1_000;
    private int[] prices;

    public static final String INFORMATION = """

        Description:
            You are given an array prices where prices[i] is the price of a given stock on the ith day.

            Find the maximum profit you can achieve. You may complete as many transactions as you like
                (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
                * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

            Note: You may not engage in multiple transactions simultaneously
                (i.e., you must sell the stock before you buy again).

        Example:
            Input: prices = [1,2,3,0,2]
            Output: 3
            Explanation: transactions = [buy, sell, cooldown, buy, sell]""";

    public BestTimeToBuyAndSellStockWithCooldown(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.prices = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Prices are {}", Arrays.toString(prices));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 621 ms
    @Override
    protected Integer original() {
        var original = new Original(prices.clone());
        return original.process();
    }

    // time = 538 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(prices.clone());
        return practice.process();
    }

    // time = 425 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(prices.clone());
        return solution.process();
    }
}
