package com.witalis.praxis.leetcode.task.h3.p227;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p227.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 227,
    description = "Basic Calculator II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, STRING, STACK}
)
public class BasicCalculatorII extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    private String expression;

    public static final String INFORMATION = """

        Given a string s which represents an expression, evaluate this expression and return its value.

        The integer division should truncate toward zero.

        You may assume that the given expression is always valid.
            All intermediate results will be in the range of [-2^31, 2^31 - 1].

        Note: You are not allowed to use any built-in function
            which evaluates strings as mathematical expressions, such as eval().

        Example:
            Input: s = " 3+5 / 2 "
            Output: 5""";

    public BasicCalculatorII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        var builder = new StringBuilder();
        var integer = true;
        var operator = '.';
        while (builder.length() < LEN) {
            builder.append(" ".repeat(random.nextInt(0, 10)));
            if (integer) {
                int origin = (operator != '/') ? 0 : 1;
                builder.append(random.nextInt(origin, 100));
            } else {
                operator = switch (random.nextInt(0, 4)) {
                    case 0 -> '+';
                    case 1 -> '-';
                    case 2 -> '*';
                    case 3 -> '/';
                    default -> ' ';
                };
                builder.append(operator);
            }
            integer = !integer;
        }
        this.expression = builder.toString();

        log.info("Expression is '{}'", expression);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3257 ms
    @Override
    protected Integer original() {
        var original = new Original(expression);
        return original.process();
    }

    // time = 2786 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(expression);
        return practice.process();
    }

    // time = 3695 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(expression);
        return solution.process();
    }
}
