package com.witalis.praxis.leetcode.task.h3.p241;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p241.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 241,
    description = "Different Ways to Add Parentheses",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, STRING, DYNAMIC_PROGRAMMING, RECURSION, MEMOIZATION}
)
public class DifferentWaysToAddParentheses extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 20;
    public static final int VALUE = 100;
    private String expression;

    public static final String INFORMATION = """

        Given a string expression of numbers and operators,
            return all possible results from computing all the different possible ways
            to group numbers and operators. You may return the answer in any order.

        Example:
            Input: expression = "2*3-4*5"
            Output: [-34,-14,-10,-10,10]
            Explanation:
                (2*(3-(4*5))) = -34
                ((2*3)-(4*5)) = -14
                ((2*(3-4))*5) = -10
                (2*((3-4)*5)) = -10
                (((2*3)-4)*5) = 10""";

    public DifferentWaysToAddParentheses(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        var builder = new StringBuilder();
        builder.append(random.nextInt(0, VALUE));
        while (builder.length() < LEN) {
            var operation = random.nextInt(0, 3);
            switch (operation) {
                case 0 -> builder.append('+');
                case 1 -> builder.append('-');
                case 2 -> builder.append('*');
            }
            builder.append(random.nextInt(0, VALUE));
        }

        this.expression = builder.toString();

        log.info("Expression is '{}'", expression);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3102 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(expression);
        return original.process();
    }

    // time = 2862 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(expression);
        return practice.process();
    }

    // time = 760 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(expression);
        return solution.process();
    }
}
