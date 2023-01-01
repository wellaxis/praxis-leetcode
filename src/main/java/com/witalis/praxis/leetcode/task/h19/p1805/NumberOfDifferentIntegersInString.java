package com.witalis.praxis.leetcode.task.h19.p1805;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1805.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1805,
    description = "Number of Different Integers in a String",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, HASH_TABLE}
)
public class NumberOfDifferentIntegersInString extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    private String word;

    public static final String INFORMATION = """

        Description:
            You are given a string word that consists of digits and lowercase English letters.

            You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34".
            Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".

            Return the number of different integers after performing the replacement operations on word.

            Two integers are considered different if their decimal representations without any leading zeros are different.

        Example:
            Input: word = "a123bc34d8ef34"
            Output: 3
            Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.""";

    public NumberOfDifferentIntegersInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('0', '9' + 1));
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }
        this.word = builder.toString();

        log.info("String 'word' is {}", word);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1590 ms
    @Override
    protected Integer original() {
        var original = new Original(word);
        return original.process();
    }

    // time = 1504 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(word);
        return practice.process();
    }

    // time = 1469 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(word);
        return solution.process();
    }
}
