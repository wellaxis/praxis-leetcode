package com.witalis.praxis.leetcode.task.h28.p2710;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h28.p2710.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2710,
    description = "Remove Trailing Zeros From a String",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class RemoveTrailingZerosFromString extends LeetCodeTask<String> {
    public static final int LEN = 1_000;

    private String number;

    public static final String INFORMATION = """

        Description:
            Given a positive integer num represented as a string, return the integer num without trailing zeros as a string.

        Example:
            Input: num = "51230100"
            Output: "512301"
            Explanation: Integer "51230100" has 2 trailing zeros, we remove them and return integer "512301".""";

    public RemoveTrailingZerosFromString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final var len = random.nextInt(1, LEN + 1);
        final var builder = new StringBuilder();
        builder.append(random.nextInt(1, 10));
        for (int i = 0; i < len; i++) {
            builder.append(random.nextInt(0, 10));
        }
        if (random.nextBoolean()) {
            builder.append("0".repeat(random.nextInt(0, 10)));
        }
        this.number = builder.toString();

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 450 ms
    @Override
    protected String original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 418 ms
    @Override
    protected String practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 413 ms
    @Override
    protected String solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
