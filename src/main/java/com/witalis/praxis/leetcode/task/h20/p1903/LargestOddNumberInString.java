package com.witalis.praxis.leetcode.task.h20.p1903;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1903.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1903,
    description = "Largest Odd Number in String",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, STRING, GREEDY}
)
public class LargestOddNumberInString extends LeetCodeTask<String> {
    public static final int LEN = 100_000;
    private String number;

    public static final String INFORMATION = """

        Description:
            You are given a string num, representing a large integer.
                Return the largest-valued odd integer (as a string)
                that is a non-empty substring of num,
                or an empty string "" if no odd integer exists.

            A substring is a contiguous sequence of characters within a string.

        Example:
            Input: num = "52"
            Output: "5"
            Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.""";

    public LargestOddNumberInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        builder.append(random.nextInt(1, 10));
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

    // time = 681 ms
    @Override
    protected String original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 664 ms
    @Override
    protected String practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 647 ms
    @Override
    protected String solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
