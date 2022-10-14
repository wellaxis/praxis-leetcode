package com.witalis.praxis.leetcode.task.h3.p299;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p299.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 299,
    description = "Bulls and Cows",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, COUNTING}
)
public class BullsAndCows extends LeetCodeTask<String> {
    public static final int LEN = 1_000;
    private String secret;
    private String guess;

    public static final String INFORMATION = """

        Description:
            You are playing the Bulls and Cows game with your friend.
    
            You write down a secret number and ask your friend to guess what the number is.
                When your friend makes a guess, you provide a hint with the following info:
                * The number of "bulls", which are digits in the guess that are in the correct position.
                * The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
                  Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.

            Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

            The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
                Note that both secret and guess may contain duplicate digits.

        Example:
            Input: secret = "1807", guess = "7810"
            Output: "1A3B"
            Explanation: Bulls are connected with a '|' and cows are underlined:
                "1807"
                  |
                "7810"
                 _ __""";

    public BullsAndCows(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder secretBuilder = new StringBuilder();
        StringBuilder guessBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            secretBuilder.append(random.nextInt(0, 10));
            guessBuilder.append(random.nextInt(0, 10));
        }

        this.secret = secretBuilder.toString();
        this.guess = guessBuilder.toString();

        log.info("Secret is '{}'", secret);
        log.info("Guess is '{}'", guess);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1630 ms
    @Override
    protected String original() {
        var original = new Original(secret, guess);
        return original.process();
    }

    // time = 608 ms
    @Override
    protected String practice() {
        var practice = new Practice(secret, guess);
        return practice.process();
    }

    // time = 535 ms
    @Override
    protected String solution() {
        var solution = new Solution(secret, guess);
        return solution.process();
    }
}
