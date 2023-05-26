package com.witalis.praxis.leetcode.task.h9.p837;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p837.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 837,
    description = "New 21 Game",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, DYNAMIC_PROGRAMMING, SLIDING_WINDOW, PROBABILITY_AND_STATISTICS}
)
public class New21Game extends LeetCodeTask<Double> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int nPoints;
    private int kPoints;
    private int maxPoints;

    public static final String INFORMATION = """

        Description:
            Alice plays the following game, loosely based on the card game "21".

            Alice starts with 0 points and draws numbers while she has less than k points.
                During each draw, she gains an integer number of points randomly from the range [1, maxPts],
                where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.

            Alice stops drawing numbers when she gets k or more points.

            Return the probability that Alice has n or fewer points.

            Answers within 10^-5 of the actual answer are considered accepted.

        Example:
            Input: n = 6, k = 1, maxPts = 10
            Output: 0.60000
            Explanation: Alice gets a single card, then stops.
                In 6 out of 10 possibilities, she is at or below 6 points.""";

    public New21Game(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.nPoints = random.nextInt(0, LEN + 1);
        this.kPoints = random.nextInt(0, nPoints + 1);
        this.maxPoints = random.nextInt(1, VALUE + 1);

        log.info("Points 'k': {}", kPoints);
        log.info("Points 'n': {}", nPoints);
        log.info("Points max: {}", maxPoints);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 671 ms
    @Override
    protected Double original() {
        var original = new Original(nPoints, kPoints, maxPoints);
        return original.process();
    }

    // time = 611 ms
    @Override
    protected Double practice() {
        var practice = new Practice(nPoints, kPoints, maxPoints);
        return practice.process();
    }

    // time = 535 ms
    @Override
    protected Double solution() {
        var solution = new Solution(nPoints, kPoints, maxPoints);
        return solution.process();
    }
}
