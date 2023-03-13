package com.witalis.praxis.leetcode.task.h8.p762;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p762.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 762,
    description = "Prime Number of Set Bits in Binary Representation",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, BIT_MANIPULATION}
)
public class PrimeNumberOfSetBitsInBinaryRepresentation extends LeetCodeTask<Integer> {
    public static final int VALUE = 1_000_000;
    public static final int DIFF = 10_000;

    private int left;
    private int right;

    public static final String INFORMATION = """

        Description:
            Given two integers left and right, return the count of numbers in the inclusive range [left, right]
                having a prime number of set bits in their binary representation.

            Recall that the number of set bits an integer has is the number of 1's present when written in binary.

            For example, 21 written in binary is 10101, which has 3 set bits.

        Example:
            Input: left = 10, right = 15
            Output: 5
            Explanation:
                10 -> 1010 (2 set bits, 2 is prime)
                11 -> 1011 (3 set bits, 3 is prime)
                12 -> 1100 (2 set bits, 2 is prime)
                13 -> 1101 (3 set bits, 3 is prime)
                14 -> 1110 (3 set bits, 3 is prime)
                15 -> 1111 (4 set bits, 4 is not prime)
                5 numbers have a prime number of set bits.""";

    public PrimeNumberOfSetBitsInBinaryRepresentation(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int diff = random.nextInt(0, DIFF + 1);
        this.left = random.nextInt(1, VALUE + 1);
        this.right = random.nextInt(left, Math.min(left + diff, VALUE + 1));

        log.info("Left: {}", left);
        log.info("Right: {}", right);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3960 ms
    @Override
    protected Integer original() {
        var original = new Original(left, right);
        return original.process();
    }

    // time = 2100 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(left, right);
        return practice.process();
    }

    // time = 1640 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(left, right);
        return solution.process();
    }
}
