package com.witalis.praxis.leetcode.task.h8.p714;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p714.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 714,
    description = "Best Time to Buy and Sell Stock with Transaction Fee",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, GREEDY}
)
public class BestTimeToBuyAndSellStockWithTransactionFee extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;
    public static final int VALUE = 50_000;

    private int[] prices;
    private int fee;

    public static final String INFORMATION = """

        Description:
            You are given an array prices where prices[i] is the price of a given stock on the ith day,
                and an integer fee representing a transaction fee.

            Find the maximum profit you can achieve. You may complete as many transactions as you like,
                but you need to pay the transaction fee for each transaction.

            Note: You may not engage in multiple transactions simultaneously
                (i.e., you must sell the stock before you buy again).

        Example:
            Input: prices = [1,3,2,8,4,9], fee = 2
            Output: 8
            Explanation: The maximum profit can be achieved by:
                - Buying at prices[0] = 1
                - Selling at prices[3] = 8
                - Buying at prices[4] = 4
                - Selling at prices[5] = 9
                The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.""";

    public BestTimeToBuyAndSellStockWithTransactionFee(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.prices = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.fee = random.nextInt(0, VALUE + 1);

        log.info("Prices: {}", Arrays.toString(prices));
        log.info("Fee: {}", fee);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1291 ms
    @Override
    protected Integer original() {
        var original = new Original(prices, fee);
        return original.process();
    }

    // time = 1048 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(prices, fee);
        return practice.process();
    }

    // time = 566 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(prices, fee);
        return solution.process();
    }
}
