package com.witalis.praxis.leetcode.task.h4.p306;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p306.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 306,
    description = "Additive Number",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, BACKTRACKING}
)
public class AdditiveNumber extends LeetCodeTask<Boolean> {
    public static final int LEN = 35;
    private String number;

    public static final String INFORMATION = """

        Description:
            An additive number is a string whose digits can form an additive sequence.

            A valid additive sequence should contain at least three numbers.
                Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

            Given a string containing only digits, return true if it is an additive number or false otherwise.

            Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

        Example:
            Input: "199100199"
            Output: true
            Explanation: The additive sequence is: 1, 99, 100, 199.
                1 + 99 = 100, 99 + 100 = 199""";

    public AdditiveNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) builder.append(random.nextInt(0, 10));
        this.number = builder.toString();

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7611 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 7332 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 2294 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
