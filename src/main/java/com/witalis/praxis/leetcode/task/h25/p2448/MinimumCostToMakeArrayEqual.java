package com.witalis.praxis.leetcode.task.h25.p2448;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2448.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2448,
    description = "Minimum Cost to Make Array Equal",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH, GREEDY, SORTING, PREFIX_SUM}
)
public class MinimumCostToMakeArrayEqual extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;

    private int[] numbers;
    private int[] costs;

    public static final String INFORMATION = """

        Description:
            You are given two 0-indexed arrays nums and cost consisting each of n positive integers.

            You can do the following operation any number of times:
                * Increase or decrease any element of the array nums by 1.

            The cost of doing one operation on the ith element is cost[i].

            Return the minimum total cost such that all the elements of the array nums become equal.

        Example:
            Input: nums = [1,3,5,2], cost = [2,3,1,14]
            Output: 8
            Explanation: We can make all the elements equal to 2 in the following way:
                - Increase the 0th element one time. The cost is 2.
                - Decrease the 1st element one time. The cost is 3.
                - Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
                The total cost is 2 + 3 + 3 = 8.
                It can be shown that we cannot make the array equal with a smaller cost.""";

    public MinimumCostToMakeArrayEqual(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);
        this.numbers = random.ints(len, 1, VALUE + 1).toArray();
        this.costs = random.ints(len, 1, VALUE + 1).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Costs: {}", Arrays.toString(costs));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 63610 ms
    @Override
    protected Long original() {
        var original = new Original(numbers.clone(), costs.clone());
        return original.process();
    }

    // time = 57412 ms
    @Override
    protected Long practice() {
        var practice = new Practice(numbers.clone(), costs.clone());
        return practice.process();
    }

    // time = 26553 ms
    @Override
    protected Long solution() {
        var solution = new Solution(numbers.clone(), costs.clone());
        return solution.process();
    }
}
