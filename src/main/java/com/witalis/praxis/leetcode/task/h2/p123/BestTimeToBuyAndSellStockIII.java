package com.witalis.praxis.leetcode.task.h2.p123;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p123.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 123,
    description = "Best Time to Buy and Sell Stock III",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class BestTimeToBuyAndSellStockIII extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;
    private int[] prices;

    public static final String INFORMATION = """

        You are given an array prices where prices[i] is the price of a given stock on the ith day.

        Find the maximum profit you can achieve. You may complete at most two transactions.

        Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

        Example:
            Input: prices = [3,3,5,0,0,3,1,4]
            Output: 6
            Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
                Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.""";

    public BestTimeToBuyAndSellStockIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.prices = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Prices are {}", prices);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 15166 ms
    @Override
    protected Integer original() {
        var original = new Original(prices);
        return original.process();
    }

    // time = 14307 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(prices);
        return practice.process();
    }

    // time = 6500 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(prices);
        return solution.process();
    }
}
