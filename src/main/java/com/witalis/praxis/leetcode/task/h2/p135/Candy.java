package com.witalis.praxis.leetcode.task.h2.p135;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p135.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 135,
    description = "Candy",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, GREEDY}
)
public class Candy extends LeetCodeTask<Integer> {
    public static final int LEN = 20_000;
    public static final int VALUE = 20_000;

    private int[] ratings;

    public static final String INFORMATION = """

        Description:
            There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

            You are giving candies to these children subjected to the following requirements:
                * Each child must have at least one candy.
                * Children with a higher rating get more candies than their neighbors.

            Return the minimum number of candies you need to have to distribute the candies to the children.

        Example:
            Input: ratings = [1,2,2]
            Output: 4
            Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
                The third child gets 1 candy because it satisfies the above two conditions.""";

    public Candy(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.ratings = random.ints(
            random.nextInt(1, LEN + 1), 0, VALUE + 1
        ).toArray();

        log.info("Ratings: {}", Arrays.toString(ratings));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 988 ms
    @Override
    protected Integer original() {
        var original = new Original(ratings);
        return original.process();
    }

    // time = 904 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(ratings);
        return practice.process();
    }

    // time = 925 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(ratings);
        return solution.process();
    }
}
