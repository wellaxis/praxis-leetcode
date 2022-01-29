package com.witalis.praxis.leetcode.task.h14.p1309;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1309.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1309,
    description = "Decrypt String from Alphabet to Integer Mapping",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class DecryptStringFromAlphabetToIntegerMapping extends LeetCodeTask<String> {
    public static final int LEN = 1_000;
    private String string;

    public static final String INFORMATION = """

        You are given a string s formed by digits and '#'.
            We want to map s to English lowercase characters as follows:

        * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
        * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.

        Return the string formed after mapping.

        The test cases are generated so that a unique mapping will always exist.

        Example:
            Input: s = "10#11#12"
            Output: "jkab"
            Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".""";

    public DecryptStringFromAlphabetToIntegerMapping(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        var builder = new StringBuilder();
        while (builder.length() < LEN) {
            int bound = random.nextBoolean() ? 10 : 27;
            int i = random.nextInt(1, bound);
            builder.append(i);
            if (i > 9) builder.append('#');
        }

        this.string = builder.toString();

        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 814 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 639 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 631 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
