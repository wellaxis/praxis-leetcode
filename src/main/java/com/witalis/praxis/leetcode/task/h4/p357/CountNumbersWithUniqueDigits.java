package com.witalis.praxis.leetcode.task.h4.p357;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p357.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 357,
    description = "Count Numbers with Unique Digits",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, DYNAMIC_PROGRAMMING, BACKTRACKING}
)
public class CountNumbersWithUniqueDigits extends LeetCodeTask<Integer> {
    public static final int LEN = 8;

    private int number;

    public static final String INFORMATION = """

        Description:
            Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10^n.

        Example:
            Input: n = 2
            Output: 91
            Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99""";

    public CountNumbersWithUniqueDigits(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.number = random.nextInt(0, LEN + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 564 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 552 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 518 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
