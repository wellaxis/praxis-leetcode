package com.witalis.praxis.leetcode.task.h24.p2390;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2390.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2390,
    description = "Removing Stars From a String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, STACK, SIMULATION}
)
public class RemovingStarsFromString extends LeetCodeTask<String> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            You are given a string s, which contains stars *.

            In one operation, you can:
                * Choose a star in s.
                * Remove the closest non-star character to its left, as well as remove the star itself.

            Return the string after all stars have been removed.
            
            Note:
                * The input will be generated such that the operation is always possible.
                * It can be shown that the resulting string will always be unique.

        Example:
            Input: s = "leet**cod*e"
            Output: "lecoe"
            Explanation: Performing the removals from left to right:
                - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
                - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
                - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
                There are no more stars, so we return "lecoe".""";

    public RemovingStarsFromString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i < 10 && random.nextBoolean() && random.nextBoolean()) {
                builder.append("*");
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }
        this.string = builder.toString();

        log.info("String: {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6492 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 4512 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 6886 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
