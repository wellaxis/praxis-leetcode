package com.witalis.praxis.leetcode.task.h2.p167;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p167.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 167,
    description = "Two Sum II - Input Array Is Sorted",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, BINARY_SEARCH}
)
public class TwoSumIIInputArrayIsSorted extends LeetCodeTask<int[]> {
    public static final int SIZE = 30_000;
    public static final int VALUE = 1_000;
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
            find two numbers such that they add up to a specific target number.
            Let these two numbers be numbers[index1] and numbers[index2]
            where 1 <= index1 < index2 <= numbers.length.

        Return the indices of the two numbers, index1 and index2,
            added by one as an integer array [index1, index2] of length 2.

        The tests are generated such that there is exactly one solution.
            You may not use the same element twice.

        Your solution must use only constant extra space.

        Example:
            Input: numbers = [2,7,11,15], target = 9
            Output: [1,2]
            Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].""";

    public TwoSumIIInputArrayIsSorted(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
                random.nextInt(2, SIZE + 1),
                -VALUE,
                VALUE + 1
            ).sorted()
            .toArray();

        this.target = numbers[random.nextInt(0, numbers.length)] +
            numbers[random.nextInt(0, numbers.length)];

        log.info("Numbers are {}", Arrays.toString(numbers));
        log.info("Target is {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 564 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers, target);
        return original.process();
    }

    // time = 511 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers, target);
        return practice.process();
    }

    // time = 425 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers, target);
        return solution.process();
    }
}
