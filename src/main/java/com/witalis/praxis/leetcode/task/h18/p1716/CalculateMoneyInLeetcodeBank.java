package com.witalis.praxis.leetcode.task.h18.p1716;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1716.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1716,
    description = "Calculate Money in Leetcode Bank",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class CalculateMoneyInLeetcodeBank extends LeetCodeTask<Integer> {
    public static final int VALUE = 1_000;

    private int number;

    public static final String INFORMATION = """

        Description:
            Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
            
            He starts by putting in $1 on Monday, the first day.
                Every day from Tuesday to Sunday, he will put in $1 more than the day before.
                On every subsequent Monday, he will put in $1 more than the previous Monday.

            Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

        Example:
            Input: n = 20
            Output: 96
            Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.""";

    public CalculateMoneyInLeetcodeBank(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, VALUE + 1);

        log.info("Number 'n': {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 499 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 480 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 423 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
