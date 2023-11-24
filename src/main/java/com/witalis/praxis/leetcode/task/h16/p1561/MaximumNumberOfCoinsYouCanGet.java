package com.witalis.praxis.leetcode.task.h16.p1561;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1561.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1561,
    description = "Maximum Number of Coins You Can Get",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, GREEDY, SORTING, GAME_THEORY}
)
public class MaximumNumberOfCoinsYouCanGet extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private int[] piles;

    public static final String INFORMATION = """

        Description:
            There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:
                * In each step, you will choose any 3 piles of coins (not necessarily consecutive).
                * Of your choice, Alice will pick the pile with the maximum number of coins.
                * You will pick the next pile with the maximum number of coins.
                * Your friend Bob will pick the last pile.
                * Repeat until there are no more piles of coins.

            Given an array of integers piles where piles[i] is the number of coins in the ith pile.

            Return the maximum number of coins that you can have.

        Example:
            Input: piles = [2,4,1,2,7,8]
            Output: 9
            Explanation: Choose the triplet (2, 7, 8), Alice Pick the pile with 8 coins, you the pile with 7 coins and Bob the last one.
                Choose the triplet (1, 2, 4), Alice Pick the pile with 4 coins, you the pile with 2 coins and Bob the last one.
                The maximum number of coins which you can have are: 7 + 2 = 9.
                On the other hand if we choose this arrangement (1, 2, 8), (2, 4, 7) you only get 2 + 4 = 6 coins which is not optimal.""";

    public MaximumNumberOfCoinsYouCanGet(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = 3 * random.nextInt(1, LEN / 3);
        this.piles = random.ints(len, 1, VALUE + 1).toArray();

        log.info("Piles: {}", Arrays.toString(piles));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 9071 ms
    @Override
    protected Integer original() {
        var original = new Original(piles.clone());
        return original.process();
    }

    // time = 1807 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(piles.clone());
        return practice.process();
    }

    // time = 1559 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(piles.clone());
        return solution.process();
    }
}
