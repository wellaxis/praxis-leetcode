package com.witalis.praxis.leetcode.task.h12.p1155;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1155.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1155,
    description = "Number of Dice Rolls With Target Sum",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING}
)
public class NumberOfDiceRollsWithTargetSum extends LeetCodeTask<Integer> {
    public static final int LEN = 30;
    public static final int VALUE = 1_000;

    private int dice;
    private int faces;
    private int target;

    public static final String INFORMATION = """

        Description:
            You have n dice, and each die has k faces numbered from 1 to k.

            Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice,
                so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.

        Example:
            Input: n = 2, k = 6, target = 7
            Output: 6
            Explanation: You throw two dice, each with 6 faces.
                There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.""";

    public NumberOfDiceRollsWithTargetSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.dice = random.nextInt(1, LEN + 1);
        this.faces = random.nextInt(1, LEN + 1);
        this.target = random.nextInt(1, VALUE + 1);

        log.info("Dice 'n': {}", dice);
        log.info("Faces 'k': {}", faces);
        log.info("Target: {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 972 ms
    @Override
    protected Integer original() {
        var original = new Original(dice, faces, target);
        return original.process();
    }

    // time = 959 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(dice, faces, target);
        return practice.process();
    }

    // time = 854 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(dice, faces, target);
        return solution.process();
    }
}
