package com.witalis.praxis.leetcode.task.h28.p2706;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h28.p2706.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2706,
    description = "Buy Two Chocolates",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING}
)
public class BuyTwoChocolates extends LeetCodeTask<Integer> {
    public static final int LEN = 50;
    public static final int VALUE = 100;

    private int[] prices;
    private int money;

    public static final String INFORMATION = """

        Description:
            You are given an integer array prices representing the prices of various chocolates in a store.
                You are also given a single integer money, which represents your initial amount of money.

            You must buy exactly two chocolates in such a way that you still have some non-negative leftover money.
                You would like to minimize the sum of the prices of the two chocolates you buy.

            Return the amount of money you will have leftover after buying the two chocolates.
                If there is no way for you to buy two chocolates without ending up in debt, return money.
                Note that the leftover must be non-negative.

        Example:
            Input: prices = [3,2,3], money = 3
            Output: 3
            Explanation: You cannot buy 2 chocolates without going in debt, so we return 3.""";

    public BuyTwoChocolates(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.prices = random.ints(
            random.nextInt(2, LEN + 1), 1, VALUE + 1
        ).toArray();
        this.money = random.nextInt(1, VALUE + 1);

        log.info("Prices: {}", Arrays.toString(prices));
        log.info("Money: {}", money);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 471 ms
    @Override
    protected Integer original() {
        var original = new Original(prices.clone(), money);
        return original.process();
    }

    // time = 450 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(prices.clone(), money);
        return practice.process();
    }

    // time = 443 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(prices.clone(), money);
        return solution.process();
    }
}
