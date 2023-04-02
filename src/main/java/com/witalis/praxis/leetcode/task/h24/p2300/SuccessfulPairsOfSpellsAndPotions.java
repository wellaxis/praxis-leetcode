package com.witalis.praxis.leetcode.task.h24.p2300;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2300.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2300,
    description = "Successful Pairs of Spells and Potions",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, BINARY_SEARCH, SORTING}
)
public class SuccessfulPairsOfSpellsAndPotions extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;
    public static final long THRESHOLD = (long) Math.pow(10, 10);

    private int[] spells;
    private int[] potions;
    private long success;

    public static final String INFORMATION = """

        Description:
            You are given two positive integer arrays spells and potions, of length n and m respectively,
                where spells[i] represents the strength of the i^th spell and potions[j] represents the strength of the j^th potion.

            You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.

            Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.

        Example:
            Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
            Output: [4,0,3]
            Explanation:
                - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
                - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
                - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
                Thus, [4,0,3] is returned.""";

    public SuccessfulPairsOfSpellsAndPotions(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.spells = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.potions = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.success = random.nextLong(1, THRESHOLD + 1);

        log.info("Spells: {}", Arrays.toString(spells));
        log.info("Potions: {}", Arrays.toString(potions));
        log.info("Success: {}", success);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 20158 ms
    @Override
    protected int[] original() {
        var original = new Original(spells.clone(), potions.clone(), success);
        return original.process();
    }

    // time = 15883 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(spells.clone(), potions.clone(), success);
        return practice.process();
    }

    // time = 4017 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(spells.clone(), potions.clone(), success);
        return solution.process();
    }
}
