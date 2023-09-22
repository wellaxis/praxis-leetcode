package com.witalis.praxis.leetcode.task.h4.p384;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p384.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 384,
    description = "Shuffle an Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, RANDOMIZED}
)
public class ShuffleArray extends LeetCodeTask<List<String>> {
    public static final int SIZE = 50;
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000;

    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, design an algorithm to randomly shuffle the array.
                All permutations of the array should be equally likely as a result of the shuffling.

            Implement the Solution class:
                * Solution(int[] nums) Initializes the object with the integer array nums.
                * int[] reset() Resets the array to its original configuration and returns it.
                * int[] shuffle() Returns a random shuffling of the array.

        Example:
            Input
                ["Solution", "shuffle", "reset", "shuffle"]
                [[[1, 2, 3]], [], [], []]
            Output
                [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
            Explanation
                Solution solution = new Solution([1, 2, 3]);
                solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                                       // Any permutation of [1,2,3] must be equally likely to be returned.
                                       // Example: return [3, 1, 2]
                solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
                solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]""";

    public ShuffleArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int[] numbers = random.ints(
            random.nextInt(1, SIZE + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("Solution", numbers));

        int len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean())
                operations.add(new AbstractMap.SimpleEntry<>("reset", null));
            else
                operations.add(new AbstractMap.SimpleEntry<>("shuffle", null));
        }

        log.info("Operations: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 8077 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 6750 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 4642 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
