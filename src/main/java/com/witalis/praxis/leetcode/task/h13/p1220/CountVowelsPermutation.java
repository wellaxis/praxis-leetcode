package com.witalis.praxis.leetcode.task.h13.p1220;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1220.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1220,
    description = "Count Vowels Permutation",
    difficulty = TaskDifficulty.HARD,
    tags = {DYNAMIC_PROGRAMMING}
)
public class CountVowelsPermutation extends LeetCodeTask<Integer> {
    public static final int LEN = 20_000;

    private int number;

    public static final String INFORMATION = """

        Description:
            Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
                * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
                * Each vowel 'a' may only be followed by an 'e'.
                * Each vowel 'e' may only be followed by an 'a' or an 'i'.
                * Each vowel 'i' may not be followed by another 'i'.
                * Each vowel 'o' may only be followed by an 'i' or a 'u'.
                * Each vowel 'u' may only be followed by an 'a'.

            Since the answer may be too large, return it modulo 10^9 + 7.

        Example:
            Input: n = 2
            Output: 10
            Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".""";

    public CountVowelsPermutation(int id, String description, TaskRevision revision) {
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

    // time = 1131 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 979 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 601 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
