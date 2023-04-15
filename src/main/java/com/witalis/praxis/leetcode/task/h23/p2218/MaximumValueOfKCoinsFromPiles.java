package com.witalis.praxis.leetcode.task.h23.p2218;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2218.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2218,
    description = "Maximum Value of K Coins From Piles",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, PREFIX_SUM}
)
public class MaximumValueOfKCoinsFromPiles extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int SIZE = 2_000;
    public static final int VALUE = 100_000;

    private List<List<Integer>> piles;
    private int coins;

    public static final String INFORMATION = """

        Description:
            There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.

            In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.

            Given a list piles, where piles[i] is a list of integers denoting the composition
                of the ith pile from top to bottom, and a positive integer k,
                return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.

        Example:
            Input: piles = [[1,100,3],[7,8,9]], k = 2
            Output: 101
            Explanation:
                The above diagram shows the different ways we can choose k coins.
                The maximum total we can obtain is 101.""";

    public MaximumValueOfKCoinsFromPiles(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);
        this.piles = new ArrayList<>(len);
        final int size = SIZE / len;
        var builder = new StringBuilder();
        int totalLen = 0;
        for (int i = 0; i < len; i++) {
            int subLen = random.nextInt(1, 2 * size);
            List<Integer> pile = random.ints(subLen, 1, VALUE + 1).boxed().toList();
            piles.add(pile);
            totalLen += subLen;
            builder.append(Arrays.toString(pile.stream().mapToInt(Integer::intValue).toArray())).append(',');
        }
        this.coins = random.nextInt(1, totalLen);

        log.info("Piles: {}", builder.substring(0, builder.length() - 1));
        log.info("Coins: {}", coins);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6770 ms
    @Override
    protected Integer original() {
        var original = new Original(piles, coins);
        return original.process();
    }

    // time = 6555 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(piles, coins);
        return practice.process();
    }

    // time = 5833 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(piles, coins);
        return solution.process();
    }
}
