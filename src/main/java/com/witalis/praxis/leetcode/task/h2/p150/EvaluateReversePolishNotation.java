package com.witalis.praxis.leetcode.task.h2.p150;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p150.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 150,
    description = "Evaluate Reverse Polish Notation",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, STACK}
)
public class EvaluateReversePolishNotation extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 200;
    private String[] tokens;

    public static final String INFORMATION = """

        Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

        Note that division between two integers should truncate toward zero.

        It is guaranteed that the given RPN expression is always valid.
            That means the expression would always evaluate to a result,
            and there will not be any division by zero operation.

        Example:
            Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
            Output: 22
            Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
                = ((10 * (6 / (12 * -11))) + 17) + 5
                = ((10 * (6 / -132)) + 17) + 5
                = ((10 * 0) + 17) + 5
                = (0 + 17) + 5
                = 17 + 5
                = 22""";

    public EvaluateReversePolishNotation(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = 2 * (random.nextInt(1, LEN) / 2) + 1;

        this.tokens = new String[len];
        int digits = 0;
        for (int i = 0; i < len; i++) {
            boolean canOperator = (digits >= 2);
            boolean canOperand = (digits <= len / 2 + 1);

            if (!canOperand) {
                tokens[i] = generateOperator();
                digits--;
            } else if (!canOperator) {
                tokens[i] = generateOperand();
                digits++;
            } else {
                if (random.nextBoolean()) {
                    tokens[i] = generateOperand();
                    digits++;
                } else {
                    tokens[i] = generateOperator();
                    digits--;
                }
            }
        }

        log.info("Tokens are {}", Arrays.toString(tokens));
    }

    private static String generateOperand() {
        final var random = ThreadLocalRandom.current();

        return String.valueOf(random.nextInt(-VALUE, VALUE + 1));
    }

    private static String generateOperator() {
        final var random = ThreadLocalRandom.current();

        int operation = random.nextInt(0, 4);
        return switch (operation) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            case 3 -> "/";
            default -> throw new IllegalStateException("Unexpected operation: " + operation);
        };
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 844 ms
    @Override
    protected Integer original() {
        var original = new Original(tokens.clone());
        return original.process();
    }

    // time = 646 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(tokens.clone());
        return practice.process();
    }

    // time = 436 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(tokens.clone());
        return solution.process();
    }
}
