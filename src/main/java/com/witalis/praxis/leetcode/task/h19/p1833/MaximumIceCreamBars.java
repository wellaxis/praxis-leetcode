package com.witalis.praxis.leetcode.task.h19.p1833;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1833.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1833,
    description = "Maximum Ice Cream Bars",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GREEDY, SORTING}
)
public class MaximumIceCreamBars extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = (int) Math.pow(10, 8);

    private int[] costs;
    private int coins;

    public static final String INFORMATION = """

        Description:
            It is a sweltering summer day, and a boy wants to buy some ice cream bars.
                                                                         
            At the store, there are n ice cream bars. You are given an array costs of length n,
                where costs[i] is the price of the ith ice cream bar in coins.
                The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible.

            Return the maximum number of ice cream bars the boy can buy with coins coins.

            Note: The boy can buy the ice cream bars in any order.

        Example:
            Input: costs = [1,3,2,4,1], coins = 7
            Output: 4
            Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.""";

    public MaximumIceCreamBars(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.costs = random.ints(
            random.nextInt(1, LEN + 1),
            1, LEN + 1
        ).toArray();
        this.coins = random.nextInt(1, VALUE + 1);

        log.info("Costs: {}", Arrays.toString(costs));
        log.info("Coins: {}", coins);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3305 ms
    @Override
    protected Integer original() {
        var original = new Original(costs.clone(), coins);
        return original.process();
    }

    // time = 3302 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(costs.clone(), coins);
        return practice.process();
    }

    // time = 2085 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(costs.clone(), coins);
        return solution.process();
    }
}
