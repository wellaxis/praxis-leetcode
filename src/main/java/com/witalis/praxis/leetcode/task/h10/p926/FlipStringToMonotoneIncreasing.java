package com.witalis.praxis.leetcode.task.h10.p926;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p926.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 926,
    description = "Flip String to Monotone Increasing",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class FlipStringToMonotoneIncreasing extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    private String string;

    public static final String INFORMATION = """

        Description:
            A binary string is monotone increasing if it consists of some number
                of 0's (possibly none), followed by some number of 1's (also possibly none).

            You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

            Return the minimum number of flips to make s monotone increasing.

        Example:
            Input: s = "010110"
            Output: 2
            Explanation: We flip to get 011111, or alternatively 000111.""";

    public FlipStringToMonotoneIncreasing(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(random.nextBoolean() ? '1' : '0');
        }
        this.string = builder.toString();

        log.info("String: {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5501 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 4751 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 3706 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
