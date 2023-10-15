package com.witalis.praxis.leetcode.task.h13.p1269;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1269.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1269,
    description = "Number of Ways to Stay in the Same Place After Some Steps",
    difficulty = TaskDifficulty.HARD,
    tags = {DYNAMIC_PROGRAMMING}
)
public class NumberOfWaysToStayInSamePlaceAfterSomeSteps extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000_000;
    public static final int STEPS = 500;

    private int steps;
    private int length;

    public static final String INFORMATION = """

        Description:
            You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left,
                1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).

            Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0
              after exactly steps steps. Since the answer may be too large, return it modulo 10^9 + 7.

        Example:
            Input: steps = 3, arrLen = 2
            Output: 4
            Explanation: There are 4 different ways to stay at index 0 after 3 steps.
                Right, Left, Stay
                Stay, Right, Left
                Right, Stay, Left
                Stay, Stay, Stay""";

    public NumberOfWaysToStayInSamePlaceAfterSomeSteps(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.steps = random.nextInt(1, STEPS + 1);
        this.length = random.nextInt(1, LEN + 1);

        log.info("Steps: {}", steps);
        log.info("Array Length: {}", length);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1870 ms
    @Override
    protected Integer original() {
        var original = new Original(steps, length);
        return original.process();
    }

    // time = 1727 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(steps, length);
        return practice.process();
    }

    // time = 1476 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(steps, length);
        return solution.process();
    }
}
