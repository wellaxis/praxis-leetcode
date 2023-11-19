package com.witalis.praxis.leetcode.task.h19.p1838;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1838.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1838,
    description = "Frequency of the Most Frequent Element",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, GREEDY, SLIDING_WINDOW, SORTING, PREFIX_SUM}
)
public class FrequencyOfMostFrequentElement extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[] numbers;
    private int operations;

    public static final String INFORMATION = """

        Description:
            The frequency of an element is the number of times it occurs in an array.

            You are given an integer array nums and an integer k.
                In one operation, you can choose an index of nums and increment the element at that index by 1.

            Return the maximum possible frequency of an element after performing at most k operations.

        Example:
            Input: nums = [1,4,8,13], k = 5
            Output: 2
            Explanation: There are multiple optimal solutions:
                - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
                - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
                - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.""";

    public FrequencyOfMostFrequentElement(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.operations = random.nextInt(1, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Operations 'k': {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7481 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), operations);
        return original.process();
    }

    // time = 7393 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), operations);
        return practice.process();
    }

    // time = 6482 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), operations);
        return solution.process();
    }
}
