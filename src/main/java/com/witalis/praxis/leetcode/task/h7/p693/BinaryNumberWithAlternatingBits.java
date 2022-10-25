package com.witalis.praxis.leetcode.task.h7.p693;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p693.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 693,
    description = "Binary Number with Alternating Bits",
    difficulty = TaskDifficulty.EASY,
    tags = {BIT_MANIPULATION}
)
public class BinaryNumberWithAlternatingBits extends LeetCodeTask<Boolean> {
    private int number;

    public static final String INFORMATION = """

        Description:
            Given a positive integer, check whether it has alternating bits:
                namely, if two adjacent bits will always have different values.

        Example:
            Input: n = 5
            Output: true
            Explanation: The binary representation of 5 is: 101""";

    public BinaryNumberWithAlternatingBits(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, Integer.MAX_VALUE);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 473 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 458 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 414 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
