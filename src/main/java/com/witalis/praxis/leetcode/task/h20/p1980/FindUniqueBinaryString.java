package com.witalis.praxis.leetcode.task.h20.p1980;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1980.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1980,
    description = "Find Unique Binary String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, STRING, BACKTRACKING}
)
public class FindUniqueBinaryString extends LeetCodeTask<String> {
    public static final int LEN = 16;

    private String[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of strings nums containing n unique binary strings each of length n,
                return a binary string of length n that does not appear in nums.
                If there are multiple answers, you may return any of them.

        Example:
            Input: nums = ["111","011","001"]
            Output: "101"
            Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.""";

    public FindUniqueBinaryString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var n = random.nextInt(1, LEN + 1);
        this.numbers = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (random.nextBoolean()) {
                    builder.append('0');
                } else {
                    builder.append('1');
                }
            }
            numbers[i] = builder.toString();
        }

        log.info("Numbers: '{}'", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 681 ms
    @Override
    protected String original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 664 ms
    @Override
    protected String practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 647 ms
    @Override
    protected String solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
