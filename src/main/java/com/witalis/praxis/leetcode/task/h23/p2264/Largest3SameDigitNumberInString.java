package com.witalis.praxis.leetcode.task.h23.p2264;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2264.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2264,
    description = "Largest 3-Same-Digit Number in String",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class Largest3SameDigitNumberInString extends LeetCodeTask<String> {
    public static final int LEN = 1_000;

    private String number;

    public static final String INFORMATION = """

        Description:
            You are given a string num representing a large integer.

            An integer is good if it meets the following conditions:
                * It is a substring of num with length 3.
                * It consists of only one unique digit.

            Return the maximum good integer as a string or an empty string "" if no such integer exists.

            Note:
                * A substring is a contiguous sequence of characters within a string.
                * There may be leading zeroes in num or a good integer.

        Example:
            Input: num = "6777133339"
            Output: "777"
            Explanation: There are two distinct good integers: "777" and "333".
                "777" is the largest, so we return "777".""";

    public Largest3SameDigitNumberInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(random.nextInt(0, 10));
        }
        this.number = builder.toString();

        log.info("Number: '{}'", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 596 ms
    @Override
    protected String original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 521 ms
    @Override
    protected String practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 518 ms
    @Override
    protected String solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
