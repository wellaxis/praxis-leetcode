package com.witalis.praxis.leetcode.task.h9.p808;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p808.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 808,
    description = "Soup Servings",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH, DYNAMIC_PROGRAMMING, PROBABILITY_AND_STATISTICS}
)
public class SoupServings extends LeetCodeTask<Double> {
    public static final int LEN = 5_000;

    private int number;

    public static final String INFORMATION = """

        Description:
            There are two types of soup: type A and type B. Initially, we have n ml of each type of soup.
                There are four kinds of operations:
                1. Serve 100 ml of soup A and 0 ml of soup B,
                2. Serve 75 ml of soup A and 25 ml of soup B,
                3. Serve 50 ml of soup A and 50 ml of soup B, and
                4. Serve 25 ml of soup A and 75 ml of soup B.

            When we serve some soup, we give it to someone, and we no longer have it.
                Each turn, we will choose from the four operations with an equal probability 0.25.
                If the remaining volume of soup is not enough to complete the operation, we will serve as much as possible.
                We stop once we no longer have some quantity of both types of soup.

            Note that we do not have an operation where all 100 ml's of soup B are used first.

            Return the probability that soup A will be empty first,
                plus half the probability that A and B become empty at the same time.
                Answers within 10^-5 of the actual answer will be accepted.

        Example:
            Input: n = 50
            Output: 0.62500
            Explanation: If we choose the first two operations, A will become empty first.
                For the third operation, A and B will become empty at the same time.
                For the fourth operation, B will become empty first.
                So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.""";

    public SoupServings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(0, LEN + 1);

        log.info("Number N: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 72749 ms
    @Override
    protected Double original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 12332 ms
    @Override
    protected Double practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 1430 ms
    @Override
    protected Double solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
