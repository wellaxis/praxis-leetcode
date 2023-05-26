package com.witalis.praxis.leetcode.task.h12.p1140;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1140.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1140,
    description = "Stone Game II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, DYNAMIC_PROGRAMMING, GAME_THEORY}
)
public class StoneGameII extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 10_000;

    private int[] piles;

    public static final String INFORMATION = """

        Description:
            Alice and Bob continue their games with piles of stones.
                There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
                The objective of the game is to end with the most stones.

            Alice and Bob take turns, with Alice starting first.
                Initially, M = 1.

            On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.
                Then, we set M = max(M, X).

            The game continues until all the stones have been taken.

            Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

        Example:
            Input: piles = [2,7,9,4,4]
            Output: 10
            Explanation:
                If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again.
                    Alice can get 2 + 4 + 4 = 10 piles in total.
                If Alice takes two piles at the beginning, then Bob can take all three piles left.
                    In this case, Alice get 2 + 7 = 9 piles in total.
                So we return 10 since it's larger.""";

    public StoneGameII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.piles = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Piles: {}", Arrays.toString(piles));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5187 ms
    @Override
    protected Integer original() {
        var original = new Original(piles);
        return original.process();
    }

    // time = 4343 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(piles);
        return practice.process();
    }

    // time = 1008 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(piles);
        return solution.process();
    }
}
