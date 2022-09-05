package com.witalis.praxis.leetcode.task.h6.p575;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p575.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 575,
    description = "Distribute Candies",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE}
)
public class DistributeCandies extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;
    private int[] candyTypes;

    public static final String INFORMATION = """

        Alice has n candies, where the ith candy is of type candyType[i].
            Alice noticed that she started to gain weight, so she visited a doctor.

        The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
            Alice likes her candies very much, and she wants to eat the maximum number
            of different types of candies while still following the doctor's advice.

        Given the integer array candyType of length n, return the maximum number of different types
            of candies she can eat if she only eats n / 2 of them.

        Example:
            Input: candyType = [1,1,2,2,3,3]
            Output: 3
            Explanation: Alice can only eat 6 / 2 = 3 candies.
                Since there are only 3 types, she can eat one of each type.""";

    public DistributeCandies(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.candyTypes = random.ints(
            2L * random.nextInt(1, LEN / 2),
            -VALUE,
            VALUE + 1
        ).toArray();

        log.info("Candy types are {}", Arrays.toString(candyTypes));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2164 ms
    @Override
    protected Integer original() {
        var original = new Original(candyTypes);
        return original.process();
    }

    // time = 1976 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(candyTypes);
        return practice.process();
    }

    // time = 1821 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(candyTypes);
        return solution.process();
    }
}
