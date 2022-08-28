package com.witalis.praxis.leetcode.task.h3.p213;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p213.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 213,
    description = "House Robber II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class HouseRobberII extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 1000;
    private int[] numbers;

    public static final String INFORMATION = """

        You are a professional robber planning to rob houses along a street.
            Each house has a certain amount of money stashed.
            All houses at this place are arranged in a circle.
            That means the first house is the neighbor of the last one.
            Meanwhile, adjacent houses have a security system connected,
            and it will automatically contact the police
            if two adjacent houses were broken into on the same night.

        Given an integer array nums representing the amount of money of each house,
            return the maximum amount of money you can rob tonight without alerting the police.

        Example:
            Input: nums = [2,3,2]
            Output: 3
            Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.""";

    public HouseRobberII(int id, String description, TaskRevision revision) {
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

    // time = 1360 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1296 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1075 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
