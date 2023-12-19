package com.witalis.praxis.leetcode.task.h12.p1175;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1175.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1175,
    description = "Prime Arrangements",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class PrimeArrangements extends LeetCodeTask<Integer> {
    public static final int LEN = 100;

    private int number;

    public static final String INFORMATION = """

        Description:
            Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)

            (Recall that an integer is prime if and only if it is greater than 1,
                and cannot be written as a product of two positive integers both smaller than it.)

            Since the answer may be large, return the answer modulo 10^9 + 7.

        Example:
            Input: n = 5
            Output: 12
            Explanation: For example [1,2,5,4,3] is a valid permutation,
                but [5,2,3,4,1] is not because the prime number 5 is at index 1.""";

    public PrimeArrangements(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        log.info("Number 'n': {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1359 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 1277 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 1270 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
