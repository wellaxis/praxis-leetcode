package com.witalis.praxis.leetcode.task.h14.p1318;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1318.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1318,
    description = "Minimum Flips to Make a OR b Equal to c",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {BIT_MANIPULATION}
)
public class MinimumFlipsToMakeAORBEqualToC extends LeetCodeTask<Integer> {
    public static final int VALUE = 1_000_000_000;

    private int numberA;
    private int numberB;
    private int numberC;

    public static final String INFORMATION = """

        Description:
            Given 3 positives numbers a, b and c.
                Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).

            Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

        Example:
            Input: a = 2, b = 6, c = 5
            Output: 3
            Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)""";

    public MinimumFlipsToMakeAORBEqualToC(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numberA = random.nextInt(1, VALUE + 1);
        this.numberB = random.nextInt(1, VALUE + 1);
        this.numberC = random.nextInt(1, VALUE + 1);

        log.info("Number 'a': {}", numberA);
        log.info("Number 'b': {}", numberB);
        log.info("Number 'c': {}", numberC);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 484 ms
    @Override
    protected Integer original() {
        var original = new Original(numberA, numberB, numberC);
        return original.process();
    }

    // time = 475 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numberA, numberB, numberC);
        return practice.process();
    }

    // time = 441 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numberA, numberB, numberC);
        return solution.process();
    }
}
