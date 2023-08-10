package com.witalis.praxis.leetcode.task.h4.p398;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p398.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 398,
    description = "Random Pick Index",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, HASH_TABLE, RESERVOIR_SAMPLING, RANDOMIZED}
)
public class RandomPickIndex extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 20_000;
    public static final int SIZE = 10_000;

    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums with possible duplicates, randomly output the index of a given target number.
                You can assume that the given target number must exist in the array.

            Implement the Solution class:
                * Solution(int[] nums) Initializes the object with the array nums.
                * int pick(int target) Picks a random index i from nums where nums[i] == target.
                  If there are multiple valid i's, then each index should have an equal probability of returning.

        Example:
            Input
                ["Solution", "pick", "pick", "pick"]
                [[[1, 2, 3, 3, 3]], [3], [1], [3]]
            Output
                [null, 4, 0, 2]
            Explanation
                Solution solution = new Solution([1, 2, 3, 3, 3]);
                solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
                solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
                solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.""";

    public RandomPickIndex(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        int[] numbers = random.ints(len, Integer.MIN_VALUE, Integer.MAX_VALUE).toArray();

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("Solution", numbers));

        for (int i = 0; i < SIZE; i++) {
            int value = numbers[random.nextInt(0, len)];
            operations.add(new AbstractMap.SimpleEntry<>("pick", new int[] {value}));
        }

        log.info("Operations: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 8384 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 7826 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 18025 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
