package com.witalis.praxis.leetcode.task.h15.p1491;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1491.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1491,
    description = "Average Salary Excluding the Minimum and Maximum Salary",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING}
)
public class AverageSalaryExcludingMinimumAndMaximumSalary extends LeetCodeTask<Double> {
    public static final int LEN = 100;
    public static final int MIN_VALUE = 1_000;
    public static final int MAX_VALUE = 100_000;

    private int[] salaries;

    public static final String INFORMATION = """

        Description:
            You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

            Return the average salary of employees excluding the minimum and maximum salary.
                Answers within 10-5 of the actual answer will be accepted.

        Example:
            Input: salary = [4000,3000,1000,2000]
            Output: 2500.00000
            Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
                Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500""";

    public AverageSalaryExcludingMinimumAndMaximumSalary(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.salaries = random.ints(
            random.nextInt(3, LEN + 1),
            MIN_VALUE,
            MAX_VALUE + 1
        ).distinct().toArray();

        log.info("Salaries: {}", Arrays.toString(salaries));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1805 ms
    @Override
    protected Double original() {
        var original = new Original(salaries.clone());
        return original.process();
    }

    // time = 514 ms
    @Override
    protected Double practice() {
        var practice = new Practice(salaries.clone());
        return practice.process();
    }

    // time = 473 ms
    @Override
    protected Double solution() {
        var solution = new Solution(salaries.clone());
        return solution.process();
    }
}
