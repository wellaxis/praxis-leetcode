package com.witalis.praxis.leetcode.task.h10.p946;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p946.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 946,
    description = "Validate Stack Sequences",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, STACK, SIMULATION}
)
public class ValidateStackSequences extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private int[] pushed;
    private int[] popped;

    public static final String INFORMATION = """

        Description:
            Given two integer arrays pushed and popped each with distinct values,
                return true if this could have been the result of a sequence of push and pop
                operations on an initially empty stack, or false otherwise.

        Example:
            Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
            Output: true
            Explanation: We might do the following sequence:
                push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1""";

    public ValidateStackSequences(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final List<Integer> numbers = new ArrayList<>(random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).distinct().boxed().toList());

        Collections.shuffle(numbers);
        this.pushed = numbers.stream().mapToInt(Integer::intValue).toArray();

        Collections.shuffle(numbers);
        this.popped = numbers.stream().mapToInt(Integer::intValue).toArray();

        log.info("Pushed: {}", Arrays.toString(pushed));
        log.info("Popped: {}", Arrays.toString(popped));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 897 ms
    @Override
    protected Boolean original() {
        var original = new Original(pushed, popped);
        return original.process();
    }

    // time = 849 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(pushed, popped);
        return practice.process();
    }

    // time = 769 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(pushed, popped);
        return solution.process();
    }
}
