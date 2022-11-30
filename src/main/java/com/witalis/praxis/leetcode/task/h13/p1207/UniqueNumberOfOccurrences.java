package com.witalis.praxis.leetcode.task.h13.p1207;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1207.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1207,
    description = "Unique Number of Occurrences",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE}
)
public class UniqueNumberOfOccurrences extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of integers arr, return true if the number of occurrences
                of each value in the array is unique, or false otherwise.

        Example:
            Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
            Output: true""";

    public UniqueNumberOfOccurrences(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // dfs, time = 7453 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers);
        return original.process();
    }

    // dfs, time = 2231 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // bfs, time = 894 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
