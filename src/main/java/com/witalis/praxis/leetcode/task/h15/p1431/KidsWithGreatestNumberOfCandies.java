package com.witalis.praxis.leetcode.task.h15.p1431;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1431.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1431,
    description = "Kids With the Greatest Number of Candies",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class KidsWithGreatestNumberOfCandies extends LeetCodeTask<List<Boolean>> {
    public static final int LEN = 100;
    public static final int VALUE = 100;
    public static final int EXTRA = 50;

    private int[] candies;
    private int extraCandies;

    public static final String INFORMATION = """

        Description:
            There are n kids with candies. You are given an integer array candies, where each candies[i] represents
                the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

            Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
                they will have the greatest number of candies among all the kids, or false otherwise.

            Note that multiple kids can have the greatest number of candies.

        Example:
            Input: candies = [2,3,5,1,3], extraCandies = 3
            Output: [true,true,true,false,true]\s
            Explanation: If you give all extraCandies to:
                - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
                - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
                - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
                - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
                - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.""";

    public KidsWithGreatestNumberOfCandies(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.candies = random.ints(
            random.nextInt(2, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.extraCandies = random.nextInt(1, EXTRA + 1);

        log.info("Candies: {}", Arrays.toString(candies));
        log.info("Extra candies: {}", extraCandies);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 833 ms
    @Override
    protected List<Boolean> original() {
        var original = new Original(candies, extraCandies);
        return original.process();
    }

    // time = 604 ms
    @Override
    protected List<Boolean> practice() {
        var practice = new Practice(candies, extraCandies);
        return practice.process();
    }

    // time = 614 ms
    @Override
    protected List<Boolean> solution() {
        var solution = new Solution(candies, extraCandies);
        return solution.process();
    }
}
