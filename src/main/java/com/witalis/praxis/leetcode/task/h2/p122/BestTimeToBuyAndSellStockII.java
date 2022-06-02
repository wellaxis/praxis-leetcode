package com.witalis.praxis.leetcode.task.h2.p122;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p122.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 122,
    description = "Best Time to Buy and Sell Stock II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, GREEDY}
)
public class BestTimeToBuyAndSellStockII extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    public static final int VALUE = 10_000;
    private int[] prices;

    public static final String INFORMATION = """

        You are given an array prices where prices[i]
            is the price of a given stock on the ith day.

        On each day, you may decide to buy and/or sell the stock.
            You can only hold at most one share of the stock at any time.
            However, you can buy it then immediately sell it on the same day.

        Find and return the maximum profit you can achieve.

        Example:
            Input: prices = [7,1,5,3,6,4]
            Output: 7
            Explanation:
                Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
                Total profit is 4 + 3 = 7.""";

    public BestTimeToBuyAndSellStockII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.prices = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE
        ).toArray();

        log.info("Prices are {}", prices);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1633 ms
    @Override
    protected Integer original() {
        var original = new Original(prices.clone());
        return original.process();
    }

    // time = 1275 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(prices.clone());
        return practice.process();
    }

    // time = 1148 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(prices.clone());
        return solution.process();
    }
}
