package com.witalis.praxis.leetcode.task.h2.p198;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p198.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 198,
    description = "House Robber",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class HouseRobber extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 400;
    private int[] numbers;

    public static final String INFORMATION = """

        You are a professional robber planning to rob houses along a street.
            Each house has a certain amount of money stashed,
            the only constraint stopping you from robbing each of them
            is that adjacent houses have security systems connected and
            it will automatically contact the police
            if two adjacent houses were broken into on the same night.

        Given an integer array nums representing the amount of money of each house,
            return the maximum amount of money you can rob tonight without alerting the police.

        Example:
            Input: nums = [2,7,9,3,1]
            Output: 12
            Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
            Total amount you can rob = 2 + 9 + 1 = 12.""";

    public HouseRobber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
                0,
                VALUE + 1
            ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 469 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 436 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 367 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
