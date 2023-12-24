package com.witalis.praxis.leetcode.task.h18.p1758;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1758.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1758,
    description = "Minimum Changes To Make Alternating Binary String",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class MinimumChangesToMakeAlternatingBinaryString extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            You are given a string s consisting only of the characters '0' and '1'.
                In one operation, you can change any '0' to '1' or vice versa.

            The string is called alternating if no two adjacent characters are equal.
                For example, the string "010" is alternating, while the string "0100" is not.

            Return the minimum number of operations needed to make s alternating.

        Example:
            Input: s = "0100"
            Output: 1
            Explanation: If you change the last character to '1', s will be "0101", which is alternating.""";

    public MinimumChangesToMakeAlternatingBinaryString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var n = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (random.nextBoolean())
                builder.append('1');
            else
                builder.append('0');
        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 910 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 618 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 837 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
