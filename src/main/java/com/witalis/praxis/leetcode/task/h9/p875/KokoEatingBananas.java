package com.witalis.praxis.leetcode.task.h9.p875;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p875.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 875,
    description = "Koko Eating Bananas",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class KokoEatingBananas extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000_000;

    private int[] piles;
    private int hours;

    public static final String INFORMATION = """

        Description:
            Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
                The guards have gone and will come back in h hours.

            Koko can decide her bananas-per-hour eating speed of k.
                Each hour, she chooses some pile of bananas and eats k bananas from that pile.
                If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

            Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

            Return the minimum integer k such that she can eat all the bananas within h hours.

        Example:
            Input: piles = [3,6,7,11], h = 8
            Output: 4""";

    public KokoEatingBananas(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.piles = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.hours = random.nextInt(piles.length, VALUE + 1);

        log.info("Piles: {}", Arrays.toString(piles));
        log.info("Hours: {}", hours);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5151 ms
    @Override
    protected Integer original() {
        var original = new Original(piles, hours);
        return original.process();
    }

    // time = 3408 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(piles, hours);
        return practice.process();
    }

    // time = 5322 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(piles, hours);
        return solution.process();
    }
}
