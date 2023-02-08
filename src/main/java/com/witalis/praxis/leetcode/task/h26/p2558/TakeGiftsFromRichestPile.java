package com.witalis.praxis.leetcode.task.h26.p2558;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h26.p2558.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2558,
    description = "Take Gifts From the Richest Pile",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HEAP, SIMULATION}
)
public class TakeGiftsFromRichestPile extends LeetCodeTask<Long> {
    public static final int LEN = 1_000;
    public static final int VALUE = (int) Math.pow(10, 9);

    private int[] gifts;
    private int seconds;

    public static final String INFORMATION = """

        Description:
            You are given an integer array gifts denoting the number of gifts in various piles.
                Every second, you do the following:
                * Choose the pile with the maximum number of gifts.
                * If there is more than one pile with the maximum number of gifts, choose any.
                * Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.

            Return the number of gifts remaining after k seconds.

        Example:
            Input: gifts = [25,64,9,4,100], k = 4
            Output: 29
            Explanation:
                The gifts are taken in the following way:
                - In the first second, the last pile is chosen and 10 gifts are left behind.
                - Then the second pile is chosen and 8 gifts are left behind.
                - After that the first pile is chosen and 5 gifts are left behind.
                - Finally, the last pile is chosen again and 3 gifts are left behind.
                The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.""";

    public TakeGiftsFromRichestPile(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.gifts = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.seconds = random.nextInt(1, LEN + 1);

        log.info("Gifts: {}", Arrays.toString(gifts));
        log.info("Seconds: {}", seconds);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4198 ms
    @Override
    protected Long original() {
        var original = new Original(gifts.clone(), seconds);
        return original.process();
    }

    // time = 3010 ms
    @Override
    protected Long practice() {
        var practice = new Practice(gifts.clone(), seconds);
        return practice.process();
    }

    // time = 786 ms
    @Override
    protected Long solution() {
        var solution = new Solution(gifts.clone(), seconds);
        return solution.process();
    }
}
