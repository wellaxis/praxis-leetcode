package com.witalis.praxis.leetcode.task.p121;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p121.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 121,
    description = "Best Time to Buy and Sell Stock",
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class BestTimeToBuyAndSellStock extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;
    private int[] prices;

    public static final String INFORMATION = """

        You are given an array prices where prices[i]
            is the price of a given stock on the ith day.

        You want to maximize your profit by choosing
            a single day to buy one stock and choosing
            a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction.
            If you cannot achieve any profit, return 0.

        Example:
            Input: prices = [7,1,5,3,6,4]
            Output: 5
            Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
                         profit = 6-1 = 5. Note that buying on day 2 and selling on day 1
                         is not allowed because you must buy before you sell.""";

    public BestTimeToBuyAndSellStock(int id, String description, TaskRevision revision) {
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

    // time = 2272 ms
    @Override
    protected Integer original() {
        var original = new Original(prices.clone());
        return original.process();
    }

    // time = 2179 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(prices.clone());
        return practice.process();
    }

    // time = 2160 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(prices.clone());
        return solution.process();
    }
}
