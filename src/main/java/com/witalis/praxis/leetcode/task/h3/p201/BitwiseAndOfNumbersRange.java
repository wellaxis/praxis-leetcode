package com.witalis.praxis.leetcode.task.h3.p201;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p201.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 201,
    description = "Bitwise AND of Numbers Range",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {BIT_MANIPULATION}
)
public class BitwiseAndOfNumbersRange extends LeetCodeTask<Integer> {
    private int left;
    private int right;

    public static final String INFORMATION = """

        Given two integers left and right that represent the range [left, right],
            return the bitwise AND of all numbers in this range, inclusive.

        Example:
            Input: left = 5, right = 7
            Output: 4""";

    public BitwiseAndOfNumbersRange(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        int number1 = generate();
        int number2 = generate();

        this.left = Math.min(number1, number2);
        this.right = Math.max(number1, number2);

        log.info("Left is {}", left);
        log.info("Right is {}", right);
    }

    private int generate() {
        return ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 681 ms
    @Override
    protected Integer original() {
        var original = new Original(left, right);
        return original.process();
    }

    // time = 443 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(left, right);
        return practice.process();
    }

    // time = 363 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(left, right);
        return solution.process();
    }
}
