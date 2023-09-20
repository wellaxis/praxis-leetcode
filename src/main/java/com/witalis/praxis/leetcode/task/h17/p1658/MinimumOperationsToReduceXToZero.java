package com.witalis.praxis.leetcode.task.h17.p1658;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1658.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1658,
    description = "Minimum Operations to Reduce X to Zero",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, BINARY_SEARCH, SLIDING_WINDOW, PREFIX_SUM}
)
public class MinimumOperationsToReduceXToZero extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;
    public static final int THRESHOLD = 1_000_000_000;

    private int[] numbers;
    private int number;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums and an integer x. In one operation, you can either remove
                the leftmost or the rightmost element from the array nums and subtract its value from x.
                Note that this modifies the array for future operations.

            Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

        Example:
            Input: nums = [1,1,4,2,3], x = 5
            Output: 2
            Explanation: The optimal solution is to remove the last two elements to reduce x to zero.""";

    public MinimumOperationsToReduceXToZero(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.number = random.nextInt(1, THRESHOLD + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Number X: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1748 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), number);
        return original.process();
    }

    // time = 846 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), number);
        return practice.process();
    }

    // time = 588 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), number);
        return solution.process();
    }
}
