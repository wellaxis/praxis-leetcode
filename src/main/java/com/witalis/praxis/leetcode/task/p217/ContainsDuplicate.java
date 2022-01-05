package com.witalis.praxis.leetcode.task.p217;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p217.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 217,
    description = "Single Number",
    tags = {ARRAY, HASH_TABLE, SORTING}
)
public class ContainsDuplicate extends LeetCodeTask<Boolean> {
    public static final int LEN = (int) Math.pow(10, 5);
    public static final int VALUE = (int) Math.pow(10, 9);
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums, return true
            if any value appears at least twice in the array,
            and return false if every element is distinct.

        Example:
            Input: nums = [1,2,3,1]
            Output: true""";

    public ContainsDuplicate(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are {}", numbers);
    }

    private int[] generate() {
        var random = ThreadLocalRandom.current();

        return random.ints(
                random.nextInt(1, LEN + 1),
                -VALUE,
                VALUE + 1
            )
            .toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 12303 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 7937 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 5275 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
