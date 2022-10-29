package com.witalis.praxis.leetcode.task.h4.p313;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p313.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 313,
    description = "Super Ugly Number",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, DYNAMIC_PROGRAMMING}
)
public class SuperUglyNumber extends LeetCodeTask<Integer> {
    public static final int NUM = 10_000;
    public static final int LEN = 100;
    public static final int VALUE = 1_000;
    private int number;
    private int[] primes;

    public static final String INFORMATION = """

        Description:
            A super ugly number is a positive integer whose prime factors are in the array primes.

            Given an integer n and an array of integers primes, return the nth super ugly number.

            The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

        Example:
            Input: n = 12, primes = [2,7,13,19]
            Output: 32
            Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].""";

    public SuperUglyNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, NUM + 1);

        int limit = random.nextInt(1, LEN + 1);
        List<Integer> list = new ArrayList<>(
            IntStream.rangeClosed(1, 2 * LEN)
                .filter(SuperUglyNumber::isPrime)
                .boxed()
                .distinct()
                .toList()
        );
        Collections.shuffle(list);
        this.primes = list.stream().limit(limit).mapToInt(Integer::intValue).toArray();
        Arrays.sort(primes);

        log.info("Number is '{}'", number);
        log.info("Primes: {}", Arrays.toString(primes));
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
            .allMatch(n -> number % n != 0);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 24070 ms
    @Override
    protected Integer original() {
        var original = new Original(number, primes);
        return original.process();
    }

    // time = 11333 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number, primes);
        return practice.process();
    }

    // time = 3551 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number, primes);
        return solution.process();
    }
}
